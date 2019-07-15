package com.cmcc.ms.redis;

import java.io.Serializable;
import java.util.List;

/**
 * redis client interface
 *
 * @author chiwei
 */
public interface RedisClient {

    /**
     * @param k
     * @param v
     * @param seconds
     */
    void put(String k, String v, int seconds);

    /**
     * 序列化
     *
     * @param k
     * @param v
     * @param seconds
     */
    <T extends Serializable> void put(String key, T v, int seconds);

    /**
     * @param key   锁名
     * @param value
     * @return
     */
    boolean setLock(String key, String value);

    /**
     * @param key
     * @return
     */
    String get(String key);

    /**
     * @param key
     * @param cls
     * @return
     */
    <T extends Serializable> T get(String key, Class<T> cls);

    /**
     * @param key
     */
    void del(String key);

    /**
     * llen:(). <br/>
     *
     * @param key
     * @return
     * @author chiwei
     * @since JDK 1.6
     */
    long llen(String key);

    /**
     * @param key
     * @param seconds
     */
    void expire(String key, int seconds);

    /**
     * @param key
     * @param obj
     */
    <T extends Serializable> void lpush(String key, T obj);

    /**
     * @param key
     * @param value
     */
    void lpush(String key, String value);

    /**
     * @param key
     * @param obj
     */
    <T extends Serializable> void rpush(String key, T obj);

    /**
     * @param key
     * @param value
     */
    void rpush(String key, String value);

    /**
     * @param key
     * @param cls
     * @return
     */
    <T extends Serializable> T rpop(String key, Class<T> cls);

    /**
     * @param key
     * @return
     */
    String rpop(String key);

    /**
     * @param key
     * @param value
     */
    void pipelineLpush(String key, List<String> value);

    /**
     * @param key
     * @param value
     */
    <T extends Serializable> void pipelineLpushProtobuf(String key, List<T> value);

}
