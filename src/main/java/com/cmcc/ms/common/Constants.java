package com.cmcc.ms.common;

public interface Constants {
	
	String DES_KEY = "4Pu8LCNdPtk=";

	String REDIS_SERVER = SystemConfig.get("redis.server");
	
	boolean SWAGGER_API_SWITCH = Boolean.parseBoolean(SystemConfig.get("swagger.api.switch"));
	
}
