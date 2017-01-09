/**  
 * Project Name:spring-boot  
 * File Name:PageController.java  
 * Package Name:com.cmcc.ms.controller  
 * Date:2016年12月9日上午11:20:26  
 * Copyright (c) 2016, chiwei@chinamobile.com All Rights Reserved.  
 *  
 */

package com.cmcc.ms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:PageController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月9日 上午11:20:26 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
@Controller
public class PageController {

	@RequestMapping("/home")
	String home(ModelMap map) {
		map.put("key", "homeValue");
		return "home";
	}

}
