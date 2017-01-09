/**  
 * Project Name:spring-boot  
 * File Name:MyTask.java  
 * Package Name:com.cmcc.ms.job  
 * Date:2016年12月27日下午3:05:30  
 * Copyright (c) 2016, chiwei@chinamobile.com All Rights Reserved.  
 *  
 */

package com.cmcc.ms.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cmcc.ms.common.DateUtil;

/**
 * ClassName:MyTask <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月27日 下午3:05:30 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
@Component
public class MyTask {

	// 定时任务示例
	@Scheduled(fixedRate = 5000)
	public void reportTime() {
		System.out.println(DateUtil.d2s(DateUtil.getCurrentDate(),
				DateUtil.YYYYMMDDHHMMSSSSSWITHSYMBOL));
	}

}
