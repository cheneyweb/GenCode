package com.cheney.gencode.gen.java.module;

import java.util.List;

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
	 * <p>Title: 获取Service</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2014年10月21日 下午3:03:05</p>
	 * 
	 * @param json
	 * @return Service
	 * @throws Exception 
	 */
	public static Service getService(String json) throws Exception{
		Service service = new Service();
		List<Method> methods = GenMethod.getMethods(json);
		service.setMethods(methods);
		return service;
	}
}
