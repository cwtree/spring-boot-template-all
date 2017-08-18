/*
 * Project: spring-boot
 * 
 * File Created at 2017年6月22日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.cmcc.ms.cmd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Type MyRunner.java
 * @Desc 
 * @author chiwei
 * @date 2017年6月22日 下午2:02:36
 * @version 
 */
/**
 * @author chiwei
 * Spring Boot启动时执行特殊的自定义代码，实现CommandLineRunner接口
 * 针对一个系统多个runner的情况，通过order的value来定义执行的先后顺序，数字越小，优先级越高
 */
@Component
@Order(value = 1)
public class MyRunner implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        logger.info("这是我自定义的执行代码，据说spring启动就会执行我");
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年6月22日 chiwei create
 */
