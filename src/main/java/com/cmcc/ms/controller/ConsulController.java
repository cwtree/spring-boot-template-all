/*
 * Project: spring-boot
 * 
 * File Created at 2017年6月21日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.cmcc.ms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Type ConsulController.java
 * @Desc 
 * @author chiwei
 * @date 2017年6月21日 下午4:51:08
 * @version 
 */
/**
 * @author chiwei
 *
 */
@RestController
public class ConsulController {
    private static Logger logger = LoggerFactory.getLogger(ConsulController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring.cloud.consul.discovery.serviceName}")
    private String instanceId;

    @RequestMapping("/consul")
    @ResponseBody
    public String consul() {
        logger.info("consul test");
        List<ServiceInstance> list = discoveryClient.getInstances(instanceId);
        StringBuffer sb = new StringBuffer();
        if (list != null && list.size() > 0) {
            for (ServiceInstance si : list) {
                sb.append(si.getHost() + ":" + si.getPort()).append("\n");
                sb.append(si.getServiceId()).append("\n");
                sb.append(si.getUri());
                sb.append("\n").append("-----------------------").append("\n");
            }
        }
        return sb.toString();
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年6月21日 chiwei create
 */
