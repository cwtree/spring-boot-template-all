package com.cmcc.ms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cmcc.ms.manager.TestManager;

/**
 * 按照系统的业务功能拆分
 * 比如userservice负责用户相关的业务逻辑处理
 * Siteservice负责网站接入相关的业务逻辑处理
 * @author chiwei
 *
 */
public interface TestService {

	public void fun();
	
	
}
