/*
 * Project: commons-cache
 * 
 * File Created at 2016年6月6日
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

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

/**
 * @Type ProtobufSerializer.java
 * @Desc
 * @author chiwei
 * @date 2016年6月6日 下午2:38:34
 * @version
 */
public class ProtobufSerializer {

	private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<Class<?>, Schema<?>>();

	private static Objenesis objenesis = new ObjenesisStd(true);

	static {
		cachedSchema.put(Boolean.class, RuntimeSchema.createFrom(Boolean.class));
		cachedSchema.put(Byte.class, RuntimeSchema.createFrom(Byte.class));
		cachedSchema.put(Short.class, RuntimeSchema.createFrom(Short.class));
		cachedSchema.put(Integer.class, RuntimeSchema.createFrom(Integer.class));
		cachedSchema.put(Long.class, RuntimeSchema.createFrom(Long.class));
		cachedSchema.put(Float.class, RuntimeSchema.createFrom(Float.class));
		cachedSchema.put(Double.class, RuntimeSchema.createFrom(Double.class));
		cachedSchema.put(Character.class, RuntimeSchema.createFrom(Character.class));
		cachedSchema.put(String.class, RuntimeSchema.createFrom(String.class));
		cachedSchema.put(BigInteger.class, RuntimeSchema.createFrom(BigInteger.class));
		cachedSchema.put(BigDecimal.class, RuntimeSchema.createFrom(BigDecimal.class));
	}

	@SuppressWarnings("unchecked")
	private static <T> Schema<T> getSchema(Class<T> cls) {
		Schema<T> schema = (Schema<T>) cachedSchema.get(cls);
		if (schema == null) {
			schema = RuntimeSchema.createFrom(cls);
			if (schema != null) {
				cachedSchema.put(cls, schema);
			}
		}
		return schema;
	}

	@SuppressWarnings("unchecked")
	public static <T> byte[] serialize(T obj) {
		Class<T> cls = (Class<T>) obj.getClass();
		LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
		try {
			Schema<T> schema = getSchema(cls);
			return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			buffer.clear();
		}
	}

	public static <T> T deserialize(byte[] bytes) {
		throw new UnsupportedOperationException();
	}

	public static <T> T deserialize(byte[] bytes, Class<T> cls) {
		try {
			T message = (T) objenesis.newInstance(cls);
			Schema<T> schema = getSchema(cls);
			ProtostuffIOUtil.mergeFrom(bytes, message, schema);
			return message;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年6月6日 chiwei create
 */
