/*
 * Project: demo
 * 
 * File Created at 2016年6月13日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.cmcc.ms.redis;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

import com.cmcc.ms.common.SysProp;

/**
 * @Type ShardRedisClient.java
 * @Desc
 * @author chiwei
 * @date 2016年6月13日 下午2:45:21
 * @version
 */
@Configuration
public class ShardRedisClient {

	@Autowired
	private SysProp sysProp;

	private ShardedJedisPool sjp;

	@Bean
	public ShardedJedisPool init() {
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxTotal(256);
		config.setMaxIdle(32);
		config.setMinIdle(4);
		config.setMaxWaitMillis(1000L);
		config.setTestWhileIdle(true);
		config.setTimeBetweenEvictionRunsMillis(30000L);
		config.setMinEvictableIdleTimeMillis(600000L);
		config.setNumTestsPerEvictionRun(-1);
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		String[] serverList = sysProp.getRedisServer().split(",", 0);
		for (String server : serverList) {
			JedisShardInfo jsi = new JedisShardInfo(server);
			jsi.setConnectionTimeout(5000);
			jsi.setSoTimeout(5000);
			shards.add(jsi);
		}
		sjp = new ShardedJedisPool(config, shards, Hashing.MURMUR_HASH,
				Sharded.DEFAULT_KEY_TAG_PATTERN);
		return sjp;
	}

	public ShardedJedis getResource() {
		return sjp.getResource();
	}

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年6月13日 chiwei create
 */
