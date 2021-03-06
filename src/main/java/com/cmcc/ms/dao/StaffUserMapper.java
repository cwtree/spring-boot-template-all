package com.cmcc.ms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cmcc.ms.dataobject.StaffUser;

/**
 * ClassName:StaffUserMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年11月10日 下午5:12:49 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
@Mapper
public interface StaffUserMapper {

	String ID = "id";
	String STAFF_ID = "staffId";
	String USERNAME = "username";
	String USERNAME_LIKE = "usernameLike";
	String MSISDN = "msisdn";
	String MSISDN_LIKE = "msisdnLike";
	String EMAIL = "email";
	String DEPARTMENT = "department";
	String DEPARTMENT_LIKE = "departmentLike";
	String POSITION = "position";
	String USER_ROLE = "userRole";

	/**
	 * 
	 * save:(). <br/>
	 * 
	 * 
	 * @author chiwei
	 * @param au
	 * @return
	 * @since JDK 1.6
	 */
	public int save(StaffUser au);

	/**
	 * 
	 * saveBatch:(). <br/>
	 * 
	 * 
	 * @author chiwei
	 * @param userList
	 * @return
	 * @since JDK 1.6
	 */
	public int saveBatch(List<StaffUser> userList);

	/**
	 * 
	 * delete:(). <br/>
	 * 
	 * 
	 * @author chiwei
	 * @param id
	 * @return
	 * @since JDK 1.6
	 */
	public int delete(Long id);

	/**
	 * 
	 * deleteLogic:(). <br/>
	 * 
	 * 
	 * @author chiwei
	 * @param paramMap
	 * @return
	 * @since JDK 1.6
	 */
	public int deleteLogic(Map<String, Object> paramMap);

	/**
	 * 
	 * update:(). <br/>
	 * 
	 * 
	 * @author chiwei
	 * @param au
	 * @return
	 * @since JDK 1.6
	 */
	public int update(StaffUser au);

	/**
	 * 
	 * find:(). <br/>
	 * 
	 * 
	 * @author chiwei
	 * @param paramMap
	 * @return
	 * @since JDK 1.6
	 */
	public List<StaffUser> find(Map<String, Object> paramMap);

	/**
	 * 
	 * findCount:(). <br/>
	 *
	 * 
	 * @author chiwei
	 * @param paramMap
	 * @return
	 * @since JDK 1.6
	 */
	public int findCount(Map<String, Object> paramMap);
}
