package com.cheney.gencode.gen.java;

import java.util.Map;
import java.util.logging.Logger;

import com.cheney.gencode.gen.java.common.GenEntityClassCode;
import com.cheney.gencode.gen.java.common.GenEntityMapperCode;
import com.cheney.gencode.gen.java.module.GenEntity;
import com.cheney.gencode.module.Entity;

/**
 * @Moudle: GenEntityCode
 * @version:v1.0
 * @Description: 生成实体代码
 * @author: xuyushuai
 * @date: 2014年10月21日 下午5:28:31
 *
 */
public class GenEntityCode {
	private static Logger log = Logger.getLogger(GenEntityCode.class.getName());
	/**
	 *
	 * <p>Title: genClass</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2014年10月22日 下午6:02:32</p>
	 * 
	 * @param json
	 */
	public static String genClass(Map<String,String> parmMap) {
		String code = null;
		try {
			String json = parmMap.get("json");
			Entity entity = GenEntity.getEntity(json);
			code = GenEntityClassCode.gen(parmMap, entity);
		} catch (Exception e) {
			log.info("入参JSON错误");
		}
		return code;
	}
	
	/**
	 *
	 * <p>Title: genMapper</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2014年10月22日 下午6:02:32</p>
	 * 
	 * @param json
	 */
	public static String genMapper(Map<String,String> parmMap) {
		String code = null;
		try {
			String json = parmMap.get("json");
			Entity entity = GenEntity.getEntity(json);
			code = GenEntityMapperCode.gen(parmMap, entity);
		} catch (Exception e) {
			log.info("入参JSON错误");
		}
		return code;
	}
}
