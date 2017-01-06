/**  
 * @Title: GenDaoCode.java
 * @Package: com.cheney.gencode
 * @Description: TODO
 * @author: xuyushuai
 * @date: 2014年10月21日 下午5:23:31
 * @version: V1.0  
 */
package com.cheney.gencode.gen.java;

import org.w3c.dom.Document;

import com.cheney.gencode.gen.common.GenImplCode;
import com.cheney.gencode.gen.common.GenInterfaceCode;
import com.cheney.gencode.gen.module.GenDao;
import com.cheney.gencode.gen.module.GenErrorDetail;
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
	 * @param document
	 * @return Dao接口代码
	 */
	public static String genInterface(Document document) {
		try {
			Dao dao = GenDao.getDao(document);
			return GenInterfaceCode.gen("Dao", dao.getMethods());
		} catch (Exception e) {
			GenErrorDetail.put("GenDaoCode.genInterface", e.getMessage());
			return null;
		}
	}

	/**
	 * <p>Title: genImpl</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:51:04</p>
	 * @param document
	 * @return Dao接口实现代码
	 */
	public static String genImpl(Document document) {
		try {
			Dao dao = GenDao.getDao(document);
			return GenImplCode.gen("Dao", dao.getMethods());
		} catch (Exception e) {
			GenErrorDetail.put("GenDaoCode.genImpl", e.getMessage());
			return null;
		}
	}
}
