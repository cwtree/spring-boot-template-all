package com.cmcc.ms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author chiwei
 *
 */
@Controller
@Slf4j
@Validated
@Api("测试")
public class TestController {

	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	@ApiOperation(value = "异常抛出", notes = "异常")
	public String exception() {
		throw new RuntimeException("异常错误");
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ApiOperation(value = "首页", notes = "首页访问")
	public String index(ModelMap m) {
		m.put("abc", "cmcc");
		return "index";
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	@ApiOperation(value = "测试", notes = "测试")
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "address", value = "地址", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "id", value = "id", dataType = "long") })
	public Object test(@NotEmpty(message = "username不能为空") String username,
			@NotEmpty(message = "address不能为空") String address,
			@NotNull(message = "id参数有误") @Range(message = "id参数有误") Long id, HttpServletRequest request,
			HttpServletResponse response) {
		log.info("参数验证");
		String specialParam = request.getParameter("spec");

		return "特殊参数注解难以满足，传统方式自行校验" + specialParam;
	}

}
