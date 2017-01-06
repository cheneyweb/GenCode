package com.cheney.gencode.gen.module;

import java.util.Map;

import com.cheney.gencode.module.Entity;

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
	 */
	public static Entity getEntity(Map<String,String> parmMap) {

		Entity entity = new Entity();
		entity.setExtendsClass(parmMap.get("extendsClass"));
		entity.setImplementsInterface(parmMap.get("implementsInterface"));

		return entity;
	}
}
