package com.cheney.gencode.gen.java;

import java.util.Map;

import com.cheney.gencode.gen.java.common.GenEntityClassCode;
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
			e.printStackTrace();
		}
		return code;
	}
}
