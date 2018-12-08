/**  
 * Project Name:spring-boot  
 * File Name:MyAsynTask.java  
 */

package com.cmcc.ms.job;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.cmcc.ms.common.DateUtil;

/**
 * ClassName:MyAsynTask <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月27日 下午3:34:29 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
@Component
public class MyAsynTask {

	@Async
	public Future<String> task1() {
		System.out.println("任务一"
				+ DateUtil.d2s(DateUtil.getCurrentDate(), DateUtil.YYYYMMDDHHMMSSSSSWITHSYMBOL));
		return new AsyncResult<String>("任务一完成");
	}

	@Async
	public Future<String> task2() {
		System.out.println("任务二"
				+ DateUtil.d2s(DateUtil.getCurrentDate(), DateUtil.YYYYMMDDHHMMSSSSSWITHSYMBOL));
		return new AsyncResult<String>("任务二完成");
	}

	@Async
	public Future<String> task3() {
		System.out.println("任务三"
				+ DateUtil.d2s(DateUtil.getCurrentDate(), DateUtil.YYYYMMDDHHMMSSSSSWITHSYMBOL));
		return new AsyncResult<String>("任务三完成");
	}

}
