package com.cmcc.ms.common;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.cmcc.aqb.enc.dec.Des;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * @Type MyPropertyLoader.java
 * @Desc
 * @author chiwei
 * @date 2017年12月5日 上午10:13:16
 * @version
 */

/**
 * @author chiwei
 */
public class MyPropertyLoader extends PropertiesPropertySourceLoader {

	private static Logger logger = LoggerFactory.getLogger(MyPropertyLoader.class);

	private static String KEY = "spring.datasource.password";

	@Override
	public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
		// TODO Auto-generated method stub
		Properties prop = PropertiesLoaderUtils.loadProperties(resource);
		if (!prop.isEmpty()) {
			if (prop.containsKey(KEY)) {
				String tmp = prop.getProperty(KEY);
				try {
					String newPwd = new String(Des.decByDes(Base64.decodeBase64(tmp), Constants.DES_KEY),
							StandardCharsets.UTF_8);
					prop.put(KEY, newPwd);
				} catch (Exception e) {
					logger.error("配置属性解密出错", e);
				}
			}
			return Collections.singletonList(new OriginTrackedMapPropertySource(name, prop));
		}
		return null;
	}

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * <p>
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年12月5日 chiwei create
 */
