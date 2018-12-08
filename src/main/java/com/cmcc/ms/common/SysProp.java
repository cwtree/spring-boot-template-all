/**  
 * Project Name:spring-boot  
 * File Name:SysProp.java  
 *  
 */

package com.cmcc.ms.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName:SysProp <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月9日 上午9:35:14 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
@Component
public class SysProp {

	@Value("${prop.my.define.p1}")
	private String p1;

	@Value("${redis.servers}")
	private String redisServer;

	public String getP1() {
		return p1;
	}

	public String getRedisServer() {
		return redisServer;
	}

}
