package com.cheney.gencode.gen.java;

import org.w3c.dom.Document;

import com.cheney.gencode.gen.common.GenImplCode;
import com.cheney.gencode.gen.common.GenInterfaceCode;
import com.cheney.gencode.gen.module.GenErrorDetail;
import com.cheney.gencode.gen.module.GenManager;
import com.cheney.gencode.module.Manager;

/**
 * @Moudle: GenManagerCode
 * @version:v1.0
 * @Description: 生成manager代码
 * @author: xuyushuai
 * @date: 2014年10月21日 下午5:23:17
 *
 */
public class GenManagerCode {
	/**
	 * <p>Title: genInterface</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:51:42</p>
	 * @param document
	 * @return Manager的接口代码
	 */
	public static String genInterface(Document document) {
		try {
			Manager manager = GenManager.getManager(document);
			return GenInterfaceCode.gen("Manager", manager.getMethods());
		} catch (Exception e) {
			GenErrorDetail.put("GenManagerCode.genInterface", e.getMessage());
			return null;
		}
	}

	/**
	 * <p>Title: genImpl</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:51:44</p>
	 * @param document
	 * @return Manager的实现代码
	 */
	public static String genImpl(Document document) {
		try {
			Manager manager = GenManager.getManager(document);
			return GenImplCode.gen("Manager", manager.getMethods());
		} catch (Exception e) {
			GenErrorDetail.put("GenManagerCode.genImpl", e.getMessage());
			return null;
		}
	}
}
