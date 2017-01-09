/**  
 * Project Name:spring-boot  
 * File Name:MyInterceptor.java  
 * Package Name:com.cmcc.ms.interceptor  
 * Date:2016年12月27日下午5:20:36  
 * Copyright (c) 2016, chiwei@chinamobile.com All Rights Reserved.  
 *  
 */

package com.cmcc.ms.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * ClassName:MyInterceptor <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月27日 下午5:20:36 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
@Aspect
@Component
public class MyInterceptor {

	private static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

	public static final String EXEC = "execution(* com.cmcc.ms.controller.*.*(..))"
			+ "&& !execution(* com.cmcc.ms.controller.*.get*(..))"
			+ "&& !execution(* com.cmcc.ms.controller.*.set*(..))";

	@Pointcut(EXEC)
	public void interceptor() {
	}

	@Around("interceptor()")
	public Object doAround(ProceedingJoinPoint point) throws Throwable {
		logger.info("===============执行切面程序");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		request.getSession();
		return point.proceed();
	}

}
