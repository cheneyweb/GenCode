package com.cheney.gencode.gen.java.module;

import com.cheney.gencode.module.Entity;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Moudle: GenDto
 * @version:v1.0
 * @Description: 生成Dto
 * @author: xuyushuai
 * @date: 2014年10月21日 下午2:55:47
 *
 */
public class GenEntity {
	/**
	 *
	 * <p>Title: 获取Entity</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2014年10月21日 下午3:03:05</p>
	 * 
	 * @param document
	 * @return Entity
	 * @throws Exception 
	 */
	public static Entity getEntity(String json) throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json,Entity.class);
	}
}
