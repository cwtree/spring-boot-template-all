/**  
 * Project Name:spring-boot  
 * File Name:MsDaoTest.java  
 */

package com.cmc.ms.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cmcc.ms.Bootstrap;
import com.cmcc.ms.dao.MsDao;

/**
 * ClassName:MsDaoTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年7月3日 下午5:29:26 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)
// SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = Bootstrap.class)
// 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
// 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class MsDaoTest {

	@Autowired
	private MsDao msDao;
	
	@Test
	public void test() {
		msDao.find("123");
	}

}
