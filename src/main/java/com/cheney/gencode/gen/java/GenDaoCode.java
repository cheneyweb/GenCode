/**  
 * @Title: GenDaoCode.java
 * @Package: com.cheney.gencode
 * @Description: TODO
 * @author: xuyushuai
 * @date: 2014年10月21日 下午5:23:31
 * @version: V1.0  
 */
package com.cheney.gencode.gen.java;

import java.util.Map;

import com.cheney.gencode.gen.java.common.GenInterfaceCode;
import com.cheney.gencode.gen.java.common.GenMapperCode;
import com.cheney.gencode.gen.java.module.GenDao;
import com.cheney.gencode.module.Dao;

/**
 * @Moudle: GenDaoCode
 * @version:v1.0
 * @Description: 生成dao代码
 * @author: xuyushuai
 * @date: 2014年10月21日 下午5:23:31
 *
 */
public class GenDaoCode {

	/**
	 * <p>Title: genInterface</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:51:02</p>
	 * @param json
	 * @return Dao接口代码
	 */
	public static String genInterface(Map<String,String> parmMap) {
		String code = null;
		try {
			String json = parmMap.get("json");
			Dao dao = GenDao.getDao(json);
			parmMap.put("moduleName","Dao");
			code = GenInterfaceCode.gen(parmMap, dao.getMethods());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}

	/**
	 * <p>Title: genMapper</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:51:04</p>
	 * @param json
	 * @return Mybatis的Mapper代码
	 */
	public static String genMapper(Map<String, String> parmMap) {
		String code = null;
		try {
			String json = parmMap.get("json");
			Dao dao = GenDao.getDao(json);
			code = GenMapperCode.gen(parmMap, dao.getMethods());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}
}
