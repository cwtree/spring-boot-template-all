/**  
 * Project Name:spring-boot  
 * File Name:MsDaoImpl.java  
 */

package com.cmcc.ms.dao;

import org.springframework.stereotype.Component;

/**
 * ClassName:MsDaoImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月8日 下午5:22:22 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
@Component
public class MsDaoImpl implements MsDao {

	@Override
	public String find(String param) {
		// TODO Auto-generated method stub
		return "查询请求 " + param;
	}

}
