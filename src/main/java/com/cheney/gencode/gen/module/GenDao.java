package com.cheney.gencode.gen.module;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.cheney.gencode.module.Dao;
import com.cheney.gencode.module.Method;

/**
 * @Moudle: GenDao
 * @version:v1.0
 * @Description: 生成Dao
 * @author: xuyushuai
 * @date: 2014年10月21日 下午2:55:47
 *
 */
public class GenDao {
	/**
	 *
	 * <p>Title: 获取Dao</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2014年10月21日 下午3:03:05</p>
	 * 
	 * @param document
	 * @return Dao
	 */
	public static Dao getDao(Document document) throws Exception {
		Dao dao = null;
		try {
			NodeList list = document.getElementsByTagName("dao");
			Element element = (Element) list.item(0);
				dao = new Dao();
				NodeList methodList = element.getElementsByTagName("method");
				// 获得所有方法
				List<Method> methods = GenMethod.getMethods(methodList);
				dao.setMethods(methods);
		} catch (Exception e) {
			GenErrorDetail.put("GenDao.getDao","Dao标签元素不存在");
			throw new Exception("获取Dao实体失败");
		}
		return dao;
	}
}
