package com.cheney.gencode.gen.java;

import org.w3c.dom.Document;

import com.cheney.gencode.gen.common.GenImplCode;
import com.cheney.gencode.gen.common.GenInterfaceCode;
import com.cheney.gencode.gen.module.GenErrorDetail;
import com.cheney.gencode.gen.module.GenService;
import com.cheney.gencode.module.Service;

/**
 * @Moudle: GenServiceCode
 * @version:v1.0
 * @Description: 生成service代码
 * @author: xuyushuai
 * @date: 2014年10月21日 下午5:23:03
 *
 */
public class GenServiceCode {

	/**
	 * <p>Title: genInterface</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:52:51</p>
	 * @param document
	 * @return Service的接口代码
	 */
	public static String genInterface(Document document) {
		try {
			Service service = GenService.getService(document);
			return GenInterfaceCode.gen("Service", service.getMethods());
		} catch (Exception e) {
			GenErrorDetail.put("GenServiceCode.genInterface", e.getMessage());
			return null;
		}
	}

	/**
	 * <p>Title: genImpl</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:52:53</p>
	 * @param document
	 * @return Service的实现代码
	 */
	public static String genImpl(Document document) {
		try {
			Service service = GenService.getService(document);
			return GenImplCode.gen("Service", service.getMethods());
		} catch (Exception e) {
			GenErrorDetail.put("GenServiceCode.genImpl", e.getMessage());
			return null;
		}
	}
}
