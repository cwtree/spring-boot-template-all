/**  
 * Project Name:spring-boot  
 * File Name:ApplicationTest.java  
 * Package Name:com.cmc.ms.test  
 * Date:2016年12月9日上午10:18:10  
 * Copyright (c) 2016, chiwei@chinamobile.com All Rights Reserved.  
 *  
 */

package com.cmc.ms.dao.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cmcc.ms.controller.MsController;
import com.cmcc.ms.job.MyAsynTask;

/**
 * ClassName:ApplicationTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月9日 上午10:18:10 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ApplicationTest {
	private MockMvc mvc;

	private MyAsynTask myAsynTask;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new MsController()).build();
		myAsynTask = new MyAsynTask();
		mvc.toString();
	}

	@Test
	public void test() {
		myAsynTask.task1();
		myAsynTask.task2();
		myAsynTask.task3();
	}
}
