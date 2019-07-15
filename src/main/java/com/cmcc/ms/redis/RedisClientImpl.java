package com.cmcc.ms.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * redis client interface implements
 *
 * @author chiwei
 */
@Component
public class RedisClientImpl implements RedisClient {

    private static Logger logger = LoggerFactory.getLogger(RedisClientImpl.class);

    @Override
    public void put(String k, String v, int seconds) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            sj.setex(k, seconds, v);
        } catch (Exception e) {
            logger.error("KV存储异常", e);
        } finally {
            sj.close();
        }
    }

    @Override
    public boolean setLock(String key, String value) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            //nx 不存在set，ex秒
            String res = sj.set(key, value, "nx", "ex", 60);
            return "OK".equals(res);
        } catch (Exception e) {
            logger.error("锁异常", e);
            sj.del(key);
        } finally {
            sj.close();
        }
        return false;
    }

    @Override
    public String get(String key) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            return sj.get(key);
        } catch (Exception e) {
            logger.error("获取数据异常", e);
        } finally {
            sj.close();
        }
        return null;
    }

    @Override
    public void del(String key) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            sj.del(key);
        } catch (Exception e) {
            logger.error("key删除异常", e);
        } finally {
            sj.close();
        }
    }

    @Override
    public <T extends Serializable> void lpush(String key, T obj) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            sj.lpush(key.getBytes(StandardCharsets.UTF_8), ProtobufSerializer.serialize(obj));
        } catch (Exception e) {
            logger.error("数据存入队列异常", e);
        } finally {
            sj.close();
        }
    }

    @Override
    public <T extends Serializable> void rpush(String key, T obj) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            sj.rpush(key.getBytes(StandardCharsets.UTF_8), ProtobufSerializer.serialize(obj));
        } catch (Exception e) {
            logger.error("数据存入队列异常", e);
        } finally {
            sj.close();
        }
    }

    @Override
    public <T extends Serializable> T rpop(String key, Class<T> cls) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            byte[] ret = sj.rpop(key.getBytes(StandardCharsets.UTF_8));// sj.rpop(key.getBytes("UTF-8"));
            return ret == null ? null : ProtobufSerializer.deserialize(ret, cls);
        } catch (Exception e) {
            logger.error("数据取出队列异常", e);
        } finally {
            sj.close();
        }
        return null;
    }

    @Override
    public <T extends Serializable> void put(String key, T v, int seconds) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            sj.setex(key.getBytes(StandardCharsets.UTF_8), seconds,
                    ProtobufSerializer.serialize(v));
        } catch (Exception e) {
            logger.error("数据序列化存入异常", e);
        } finally {
            sj.close();
        }
    }

    @Override
    public <T extends Serializable> T get(String key, Class<T> cls) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            byte[] ret = sj.get(key.getBytes(StandardCharsets.UTF_8));
            return ret == null ? null : ProtobufSerializer.deserialize(ret, cls);
        } catch (Exception e) {
            logger.error("数据序列化取出异常", e);
        } finally {
            sj.close();
        }
        return null;
    }

    @Override
    public void expire(String key, int seconds) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            sj.expire(key, seconds);
        } catch (Exception e) {
            logger.error("key设置有效期异常", e);
        } finally {
            sj.close();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.cmcc.screenshot.redis.RedisClient#rpop(java.lang.String)
     */
    @Override
    public String rpop(String key) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            return sj.rpop(key);
        } catch (Exception e) {
            logger.error("队列取数据异常", e);
        } finally {
            sj.close();
        }
        return null;
    }

    @Override
    public void lpush(String key, String value) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            sj.lpush(key, value);
        } catch (Exception e) {
            logger.error("数据存入队列异常", e);
        } finally {
            sj.close();
        }
    }

    @Override
    public void rpush(String key, String value) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            sj.rpush(key, value);
        } catch (Exception e) {
            logger.error("数据存入队列异常", e);
        } finally {
            sj.close();
        }
    }

    @Override
    public void pipelineLpush(String key, List<String> value) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            ShardedJedisPipeline p = sj.pipelined();
            for (String str : value) {
                p.lpush(key, str);
            }
            p.sync();
        } catch (Exception e) {
            logger.error("数据存入队列异常", e);
        } finally {
            sj.close();
        }
    }

    @Override
    public <T extends Serializable> void pipelineLpushProtobuf(String key, List<T> value) {
        // TODO Auto-generated method stub
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            ShardedJedisPipeline p = sj.pipelined();
            for (T obj : value) {
                p.lpush(key.getBytes(StandardCharsets.UTF_8), ProtobufSerializer.serialize(obj));
            }
            p.sync();
        } catch (Exception e) {
            logger.error("数据存入队列异常", e);
        } finally {
            sj.close();
        }
    }

    @Override
    public long llen(String key) {
        // TODO Auto-generated method stub  
        ShardedJedis sj = null;
        try {
            sj = RedisConfig.getResource();
            return sj.llen(key);
        } catch (Exception e) {
            logger.error("获取队列长度异常", e);
            return 0;
        } finally {
            sj.close();
        }
    }

}
