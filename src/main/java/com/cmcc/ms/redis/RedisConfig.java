package com.cmcc.ms.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

import java.util.ArrayList;
import java.util.List;

/**
 * redis config init
 *
 * @author chiwei
 */
public class RedisConfig {

    private static ShardedJedisPool sjp;

    /**
     * 初始化方法
     *
     * @param redisServer
     */
    @SuppressWarnings("rawtypes")
	public static void init(String redisServer) {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(256);
        config.setMaxIdle(32);
        config.setMinIdle(4);
        config.setMaxWaitMillis(1000L);
        config.setTestWhileIdle(true);
        config.setTimeBetweenEvictionRunsMillis(30000L);
        config.setMinEvictableIdleTimeMillis(600000L);
        config.setNumTestsPerEvictionRun(-1);
        config.setJmxEnabled(false);
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        String[] serverList = redisServer.split(",", 0);
        for (String server : serverList) {
            JedisShardInfo jsi = new JedisShardInfo(server);
            jsi.setConnectionTimeout(5000);
            jsi.setSoTimeout(5000);
            shards.add(jsi);
        }
        sjp = new ShardedJedisPool(config, shards, Hashing.MURMUR_HASH,
                Sharded.DEFAULT_KEY_TAG_PATTERN);
    }

    public static ShardedJedis getResource() {
        return sjp.getResource();
    }
}
