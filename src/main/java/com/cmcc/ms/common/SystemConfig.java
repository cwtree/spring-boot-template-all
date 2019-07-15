package com.cmcc.ms.common;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * ClassName: SystemConfig <br/>
 * date: 2018年1月31日 下午4:50:03 <br/>
 *
 * @author chiwei
 * @version 1.0
 * @since JDK 1.6
 */
public class SystemConfig {

    private static Properties prop = new Properties();

    static {
        try {
            InputStream in = new FileInputStream("config/config.properties");
            prop.load(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param key key
     * @return value
     */
    public static String get(String key) {
        String str = prop.getProperty(key);
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str.trim())) {
            return "";
        }
        return str.trim();
    }

}
