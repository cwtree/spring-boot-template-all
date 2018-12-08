/*
 * Project: erebus
 * 
 * File Created at 2017-8-16
 * 
 */
package com.cmc.ms.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cmcc.ms.Bootstrap;
import com.cmcc.ms.dao.AdminUserMapper;
import com.cmcc.ms.dataobject.AdminUser;

/**
 * @Type AdminUserMapperTest.java
 * @Desc 
 * @author puchuncheng
 * @date 2017-8-16 下午3:47:25
 * @version 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bootstrap.class)
@WebAppConfiguration
public class AdminUserMapperTest {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Test
    public void testFind() {
        List<AdminUser> adminUserList = adminUserMapper.find(null);
        for (AdminUser adminUser : adminUserList) {
            System.out.println(adminUser);
        }
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017-8-16 puchuncheng creat
 */
