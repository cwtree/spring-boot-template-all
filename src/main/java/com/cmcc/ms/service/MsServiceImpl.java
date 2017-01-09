package com.cmcc.ms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.cmcc.ms.common.Condition;
import com.cmcc.ms.common.DalConstants;
import com.cmcc.ms.common.SysProp;
import com.cmcc.ms.dao.AdminUserMapper;
import com.cmcc.ms.dao.MsDao;
import com.cmcc.ms.dataobject.AdminUser;
import com.cmcc.ms.vo.MsVO;
import com.google.common.base.Charsets;

@Service
public class MsServiceImpl implements MsService {

	private static Logger logger = LoggerFactory.getLogger(MsServiceImpl.class);

	@Autowired
	private MsDao msDao;

	@Autowired
	private SysProp sysProp;

	@Autowired
	private AdminUserMapper adminUserMapper;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private VelocityEngine velocityEngine;

	public MsVO findMs() {
		MsVO mv = new MsVO();
		mv.setTitle(sysProp.getP1());
		mv.setContent(msDao.find("test"));
		mv.setCount(10);
		return mv;
	}

	public void addAdminUser(AdminUser au) {
		adminUserMapper.save(au);
	}

	public AdminUser findAdminUserById(Long id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(Condition.IS_DELETED, DalConstants.IS_NOT_DELETED);
		paramMap.put(Condition.ID, id);
		List<AdminUser> list = adminUserMapper.find(paramMap);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void sendMail(String receiver, String subject, String content) {
		// TODO Auto-generated method stub
		// 普通邮件发送
		// SimpleMailMessage message = new SimpleMailMessage();
		// message.setFrom("wlanplatform@163.com");
		// message.setTo("719259043@qq.com");
		// message.setSubject("下次过来吃饭");
		// message.setText("这是一封邮件，欢迎您！下次来玩啊！");
		// mailSender.send(message);
		// 附件发送
		// MimeMessage mm = mailSender.createMimeMessage();
		// try {
		// MimeMessageHelper helper = new MimeMessageHelper(mm, true);
		// helper.setFrom("wlanplatform@163.com");
		// helper.setTo("wlanplatform@163.com");
		// helper.setSubject("明天去看电影吗？");
		// helper.setText("明天一起去西溪印象城看电影吗？功夫瑜伽啊？");
		// FileSystemResource file = new FileSystemResource(new
		// File("c://abc.csv"));
		// helper.addAttachment("234544.csv", file);
		// mailSender.send(mm);
		// } catch (Exception e) {
		// logger.error("邮件附件错误", e);
		// throw new RuntimeException(e);
		// }
		// 嵌入静态资源
		// MimeMessage mm = mailSender.createMimeMessage();
		// try {
		// MimeMessageHelper helper = new MimeMessageHelper(mm, true);
		// helper.setFrom("wlanplatform@163.com");
		// helper.setTo("wlanplatform@163.com");
		// helper.setSubject("明天去看电影吗？");
		// helper.setText(
		// "看电影，功夫瑜伽！<html><body><img src=\"cid:myStaticResource\" ></body></html>",
		// true);
		// FileSystemResource file = new FileSystemResource(new
		// File("c://xxx.jpg"));
		// helper.addInline("myStaticResource", file);
		// mailSender.send(mm);
		// } catch (Exception e) {
		// logger.error("邮件静态资源错误", e);
		// throw new RuntimeException(e);
		// }
		// 模板邮件
		MimeMessage mm = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mm, true);
			helper.setFrom("wlanplatform@163.com");
			helper.setTo("wlanplatform@163.com");
			Map<String, Object> context = new HashMap<String, Object>();
			context.put("account", "池伟");
			String[] text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
					"/templates/mail/hello.vm", Charsets.UTF_8.toString(), context).split("\\*{5}");
			helper.setSubject(text[0]);
			helper.setText(text[1], true);
			mailSender.send(mm);
		} catch (Exception e) {
			logger.error("邮件模板错误", e);
			throw new RuntimeException(e);
		}
	}

}
