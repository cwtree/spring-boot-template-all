/**  
 * Project Name:spring-boot  
 * File Name:GlobalExceptionHandler.java  
 */

package com.cmcc.ms.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

/**
 * ClassName:GlobalExceptionHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月9日 上午11:04:38 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public JSONObject handler(HttpServletRequest req, Exception e) throws Exception {
		JSONObject json = new JSONObject();
		json.put("url", req.getRequestURL());
		json.put("exception", e.getMessage());
		return json;
	}
}
