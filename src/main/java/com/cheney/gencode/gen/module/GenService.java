package com.cheney.gencode.gen.module;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.cheney.gencode.module.Method;
import com.cheney.gencode.module.Service;

/**
 * @Moudle: GenService
 * @version:v1.0
 * @Description: 生成GenService
 * @author: xuyushuai
 * @date: 2014年10月21日 下午2:55:47
 *
 */
public class GenService {
	/**
	 *
	 * <p>Title: 获取Manager</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2014年10月21日 下午3:03:05</p>
	 * 
	 * @param document
	 * @return Manager
	 * @throws Exception 
	 */
	public static Service getService(Document document) throws Exception {
		Service service = null;
		try {
			NodeList list = document.getElementsByTagName("service");
			Element element = (Element) list.item(0);

			service = new Service();
			NodeList methodList = element.getElementsByTagName("method");
			// 获得所有方法
			List<Method> methods = GenMethod.getMethods(methodList);
			service.setMethods(methods);
		} catch (Exception e) {
			GenErrorDetail.put("GenService.getService", "Service标签元素不存在");
			throw new Exception("获取Service实体失败");
		}
		return service;
	}
}
