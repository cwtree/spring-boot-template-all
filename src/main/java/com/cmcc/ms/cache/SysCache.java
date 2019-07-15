package com.cmcc.ms.cache;

import java.util.List;

import com.cmcc.ms.dataobject.StaffUser;

public interface SysCache {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public StaffUser findSuById(long id);
	
	/**
	 * 
	 * @param department
	 * @return
	 */
	public List<StaffUser> findSuListByDepartment(String department);
	
}
