/**  
 * Project Name:admin.data  
 * File Name:AdminUser.java  
 * Package Name:com.cmcc.admin.data.dataobject  
 * Date:2016年11月10日下午5:11:22  
 * Copyright (c) 2016, chiwei@chinamobile.com All Rights Reserved.  
 *  
 */

package com.cmcc.ms.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName:AdminUser <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年11月10日 下午5:11:22 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
public class AdminUser implements Serializable {
	/**
	 * serialVersionUID:TODO().
	 * 
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String staffId;
	private String username;
	private String msisdn;
	private String email;
	private String adminPwd;
	private String salt;
	private String department;
	private String position;
	private int userRole;
	private Long createId;
	private Long updateId;
	private Date createTime;
	private Date updateTime;
	private int isDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName()).append("[");
        sb.append("id : ").append(id).append(", ");
        sb.append("staffId : ").append(staffId).append(", ");
        sb.append("username : ").append(username).append(", ");
        sb.append("msisdn : ").append(msisdn).append(", ");
        sb.append("email : ").append(email).append(", ");
        sb.append("adminPwd : ").append(adminPwd).append(", ");
        sb.append("salt : ").append(salt).append(", ");
        sb.append("department : ").append(department).append(", ");
        sb.append("position : ").append(position).append(", ");
        sb.append("userRole : ").append(userRole).append(", ");
        sb.append("createId : ").append(createId).append(", ");
        sb.append("updateId : ").append(updateId).append(", ");
        sb.append("createTime : ").append(createTime).append(", ");
        sb.append("department : ").append(department).append(", ");
        sb.append("updateTime : ").append(updateTime).append(", ");
        sb.append("isDeleted : ").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }
}
