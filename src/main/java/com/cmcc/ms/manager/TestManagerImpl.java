package com.cmcc.ms.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.ms.cache.SysCache;
import com.cmcc.ms.dataobject.StaffUser;
import com.cmcc.ms.vo.TestVO;

/**
 * manager禁止引入dao，数据层操作全部通过sysCache
 * @author chiwei
 *
 */
@Service
public class TestManagerImpl implements TestManager {

	@Autowired
	private SysCache sysCache;

	@Override
	public TestVO testFun(long args) {
		// TODO Auto-generated method stub
		StaffUser su = sysCache.findSuById(args);
		TestVO tv = new TestVO();
		tv.setDepartment(su.getDepartment());
		tv.setUsername(su.getUsername());
		return tv;
	}

}
