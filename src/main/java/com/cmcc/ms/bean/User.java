/**  
 * Project Name:spring-boot  
 * File Name:User.java  
 * Package Name:com.cmcc.ms.bean  
 * Date:2016年12月9日下午2:16:02  
 * Copyright (c) 2016, chiwei@chinamobile.com All Rights Reserved.  
 *  
 */

package com.cmcc.ms.bean;

import java.io.Serializable;

/**
 * ClassName:User <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月9日 下午2:16:02 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
public class User implements Serializable {

	/**
	 * serialVersionUID:TODO().
	 * 
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String pwd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
