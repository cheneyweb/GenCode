package com.cheney.gencode.gen.java.module;

import org.apache.commons.lang.StringUtils;

import com.cheney.gencode.module.GlobalConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Moudle: GenGlobalConfig
 * @version:v1.0
 * @Description: 生成全局配置
 * @author: xuyushuai
 * @date: 2014年10月21日 下午2:55:47
 *
 */
public class GenGlobalConfig {
	
	public static GlobalConfig getGlobalConfig(String json) {
		try {
			if(StringUtils.isNotEmpty(json)){
				ObjectMapper objectMapper = new ObjectMapper();
				return objectMapper.readValue(json,GlobalConfig.class);
			}else{
				return new GlobalConfig();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
        
}
