package com.cmcc.ms.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.ms.common.Condition;
import com.cmcc.ms.dao.StaffUserMapper;
import com.cmcc.ms.dataobject.StaffUser;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SysCacheImpl implements SysCache {

	@Autowired
	private StaffUserMapper adminUserMapper;

	@Override
	public StaffUser findSuById(long id) {
		// TODO Auto-generated method stub
		log.info("findSuById 入口");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(Condition.ID, id);
		List<StaffUser> list = adminUserMapper.find(paramMap);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<StaffUser> findSuListByDepartment(String department) {
		// TODO Auto-generated method stub
		log.info("findSuListByDepartment 入口");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(StaffUserMapper.DEPARTMENT, department);
		return adminUserMapper.find(paramMap);
	}

}
