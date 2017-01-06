package com.cheney.gencode.gen.module;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.cheney.gencode.module.Manager;
import com.cheney.gencode.module.Method;

/**
 * @Moudle: GenManager
 * @version:v1.0
 * @Description: 生成Manager
 * @author: xuyushuai
 * @date: 2014年10月21日 下午2:55:47
 *
 */
public class GenManager {
	/**
	 *
	 * <p>Title: 获取Manager</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2014年10月21日 下午3:03:05</p>
	 * 
	 * @param document
	 * @return Manager
	 */
	public static Manager getManager(Document document) throws Exception{
		Manager manager = null;
		try {
			NodeList list = document.getElementsByTagName("manager");
			Element element = (Element) list.item(0);

			manager = new Manager();
			NodeList methodList = element.getElementsByTagName("method");
			// 获得所有方法
			List<Method> methods = GenMethod.getMethods(methodList);
			manager.setMethods(methods);
		} catch (Exception e) {
			GenErrorDetail.put("GenManager.getManager", "Manager标签元素不存在");
			throw new Exception("获取Manager实体失败");
		}
		return manager;
	}
}
