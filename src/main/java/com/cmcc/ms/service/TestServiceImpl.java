package com.cmcc.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.ms.cache.SysCache;
import com.cmcc.ms.manager.TestManager;

/**
 * service禁止引入dao，数据层操作全部通过sysCache
 * @author chiwei
 *
 */
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private SysCache sysCache;
	
	@Autowired
	private TestManager	 testManager;
	
	@Override
	public void fun() {
		// TODO Auto-generated method stub
		sysCache.findSuById(1);
		testManager.testFun(1L);
	}

}
