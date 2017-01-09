package com.cmcc.ms.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.ShardedJedis;

import com.cmcc.ms.bean.User;
import com.cmcc.ms.common.SysProp;
import com.cmcc.ms.dataobject.AdminUser;
import com.cmcc.ms.redis.ProtobufSerializer;
import com.cmcc.ms.redis.ShardRedisClient;
import com.cmcc.ms.service.MsService;
import com.cmcc.ms.vo.MsVO;

@RestController
public class MsController {

	private static Logger logger = LoggerFactory.getLogger(MsController.class);

	@Autowired
	private SysProp sysProp;

	@Autowired
	private MsService msService;

	@Autowired
	private ShardRedisClient shardRedisClient;

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		logger.warn("------------------------打印warn日志");
		return sysProp.getP1();
	}

	@RequestMapping("/exception")
	public String exception() {
		throw new RuntimeException("异常错误");
	}

	@RequestMapping("/biz")
	public MsVO biz() {
		return msService.findMs();
	}

	// redis缓存的示例
	@RequestMapping("/putCache")
	public String putCache(HttpServletRequest req) throws Exception {
		User user = new User();
		user.setId(2L);
		user.setPwd("pwd");
		user.setUsername("chiwei");
		logger.info("=========================缓存放入");
		ShardedJedis sj = shardRedisClient.getResource();
		sj.setex("chiwei".getBytes("UTF-8"), 1000, ProtobufSerializer.serialize(user));
		sj.close();
		return "OK";
	}

	@RequestMapping("/getCache")
	public User getCache(HttpServletRequest req) throws Exception {
		ShardedJedis sj = shardRedisClient.getResource();
		byte[] res = sj.get("chiwei".getBytes("UTF-8"));
		User user = ProtobufSerializer.deserialize(res, User.class);
		return user;
	}

	// 数据库mysql的示例
	@RequestMapping("/addAdminUser")
	public String addAdminUser() {
		AdminUser au = new AdminUser();
		au.setMsisdn("18867101080");
		msService.addAdminUser(au);
		return "OK";
	}

	@RequestMapping("/findAdminUser")
	public AdminUser findAdminUser(HttpServletRequest req) {
		return msService.findAdminUserById(Long.valueOf(req.getParameter("id")));
	}

	@RequestMapping("/sendMail")
	String sendMail(HttpServletRequest req) {
		msService.sendMail("719259043@qq.com", "主题邮件", "邮件内容");
		return "OK";
	}
}
