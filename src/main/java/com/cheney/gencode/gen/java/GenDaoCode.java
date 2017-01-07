/**  
 * @Title: GenDaoCode.java
 * @Package: com.cheney.gencode
 * @Description: TODO
 * @author: xuyushuai
 * @date: 2014年10月21日 下午5:23:31
 * @version: V1.0  
 */
package com.cheney.gencode.gen.java;

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
	public static String genInterface(String json) {
		String code = null;
		try {
//			Dao dao = GenDao.getDao(json);
//			code = GenInterfaceCode.gen("Dao", dao.getMethods());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}

	/**
	 * <p>Title: genImpl</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:51:04</p>
	 * @param json
	 * @return Dao接口实现代码
	 */
	public static String genImpl(String json) {
		String code = null;
		try {
//			Dao dao = GenDao.getDao(json);
//			code = GenImplCode.gen("Dao", dao.getMethods());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}
}
