package com.cmcc.ms.dataobject;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * ClassName:StaffUser <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年11月10日 下午5:11:22 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
@Getter
@Setter
public class StaffUser implements Serializable {
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
	private String creator;
	private String updator;
	private Date createTime;
	private Date updateTime;
	private int isDeleted;

}
