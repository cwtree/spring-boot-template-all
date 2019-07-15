package com.cmc.ms.dao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cmcc.ms.Bootstrap;
import com.cmcc.ms.common.Condition;
import com.cmcc.ms.common.DalConstants;
import com.cmcc.ms.common.DateUtil;
import com.cmcc.ms.dao.StaffUserMapper;
import com.cmcc.ms.dataobject.StaffUser;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Bootstrap.class)
@WebAppConfiguration
public class StaffUserMapperTest {

	
	@Autowired
    private StaffUserMapper staffUserMapper;

    /**
     * 
     */
    @Test
    public void test() {
        //保存数据
    	StaffUser bean = new StaffUser();
    	bean.setStaffId("10101");
    	bean.getStaffId();
        bean.setCreator("chiwei");
        bean.getCreator();
        bean.setUpdator("up");
        bean.getUpdator();
        bean.setUsername("zhangsan");
        bean.getUsername();
        bean.setMsisdn("188");
        bean.getMsisdn();
        bean.setEmail("@");
        bean.getEmail();
        bean.setAdminPwd("pwd");
        bean.getAdminPwd();
        bean.setIsDeleted(DalConstants.IS_NOT_DELETED);
        bean.getIsDeleted();
        bean.setCreateTime(DateUtil.getCurrentTime());
        bean.getCreateTime();
        bean.setSalt("salt");
        bean.getSalt();
        bean.setDepartment("安全");
        bean.getDepartment();
        bean.setPosition("pos");
        bean.getPosition();
        bean.setUserRole(1);
        bean.getUserRole();
        bean.setUpdateTime(DateUtil.getCurrentTime());
        bean.getUpdateTime();
        bean.toString();
        int res = staffUserMapper.save(bean);
        TestCase.assertTrue(1 == res);
        //查询数据
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put(Condition.ID, bean.getId());
        paramMap.put(Condition.IS_DELETED, DalConstants.IS_NOT_DELETED);
        List<StaffUser> list = staffUserMapper.find(paramMap);
        TestCase.assertTrue(list.size() == 1);
        TestCase.assertTrue("chiwei".equals(list.get(0).getCreator()));
        paramMap.clear();
        paramMap.put(StaffUserMapper.USERNAME, "zhangsan");
        paramMap.put(Condition.IS_DELETED, DalConstants.IS_NOT_DELETED);
        list = staffUserMapper.find(paramMap);
        TestCase.assertTrue(list.size() == 1);
        TestCase.assertTrue("chiwei".equals(list.get(0).getCreator()));
        int sum = staffUserMapper.findCount(paramMap);
        TestCase.assertTrue(sum == 1);
        //更新数据
        bean.setSalt("salt");
        res = staffUserMapper.update(bean);
        list = staffUserMapper.find(paramMap);
        TestCase.assertTrue(list.size() == 1);
        TestCase.assertTrue("salt".equals(list.get(0).getSalt()));
        //删除数据
        res = staffUserMapper.delete(bean.getId());
        TestCase.assertTrue(1 == res);
        list = staffUserMapper.find(paramMap);
        TestCase.assertTrue(list.size() == 0);
    }
	
}
