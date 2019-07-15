package com.cmc.ms.manager.test;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.cmcc.ms.cache.SysCache;
import com.cmcc.ms.dataobject.StaffUser;
import com.cmcc.ms.manager.TestManager;
import com.cmcc.ms.manager.TestManagerImpl;

public class TestManagerTest {

	private Mockery context;
	private TestManager testManager;
	private SysCache sysCache;

	@Before
	public void setUp() throws Exception {
		context = new JUnit4Mockery();
		testManager = new TestManagerImpl();
		sysCache = context.mock(SysCache.class);
		ReflectionTestUtils.setField(testManager, "sysCache", sysCache);
	}

	@Test
	public void testDeleteAlertByMonitorPageId() throws Exception {
		StaffUser su = new StaffUser();
		su.setUsername("123");
		su.setDepartment("safe");
		context.checking(new Expectations() {
			{
				oneOf(sysCache).findSuById(with(any(Long.class)));
				will(returnValue(su));
			}
		});

		testManager.testFun(1);
	}
}
