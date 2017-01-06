package com.cheney.gencode.gen.common;

import org.springframework.util.StringUtils;

import com.cheney.gencode.enums.EnumShortcut;
import com.cheney.gencode.module.Entity;

/**
 * @Moudle: GenClassHeadCode 
 * @version:v1.0
 * @Description: 生成类头部代码
 * @author: xuyushuai
 * @date: 2015年5月4日 上午10:45:10
 *
 */
public class GenClassHeadCode {
	/**
	 * <p>Title: gen</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:45:12</p>
	 * @param className
	 * @param object
	 * @return 类头部代码
	 */
	public static String gen(String className, Object object) {
		Entity o = (Entity) object;
		String code = "";
		code += "public class ";
		code += className;
		if (!StringUtils.isEmpty(o.getExtendsClass())) {
			code += " extends ";
			code += o.getExtendsClass();
		}
		if (!StringUtils.isEmpty(o.getImplementsInterface())) {
			code += " implements ";
			code += o.getImplementsInterface();
		}
		code += "{";
		code += EnumShortcut.NL2.getValue();
		return code;
	}
}
