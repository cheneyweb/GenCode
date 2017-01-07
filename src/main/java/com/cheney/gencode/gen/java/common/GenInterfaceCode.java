package com.cheney.gencode.gen.java.common;

import java.util.List;
import java.util.Map;

import com.cheney.gencode.enums.EnumShortcut;
import com.cheney.gencode.gen.java.comment.GenClassHeadComment;
import com.cheney.gencode.module.Method;

/**
 * @Moudle: GenInterfaceCode
 * @version:v1.0
 * @Description: 生成接口代码
 * @author: xuyushuai
 * @date: 2015年3月26日 上午11:51:03
 *
 */
public class GenInterfaceCode {
	/**
	 * <p>Title: gen</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:50:19</p>
	 * @param moduleName
	 * @param methods
	 * @return 接口代码
	 */ 
	public static String gen(Map<String,String> parmMap,List<Method> methods) {
		// 入参设置
		String moduleName = parmMap.get("moduleName");
		String prefix = parmMap.get("prefix");
		String basepackage = parmMap.get("basepackage");
		String author = parmMap.get("author");
		// 生成Service接口文件
		String interfaceName = prefix + moduleName;
		
		StringBuffer sb = new StringBuffer();
		// 包名
		sb.append("package " + basepackage + "."+moduleName.toLowerCase()+";");
		sb.append(EnumShortcut.NL2.getValue());
		// 接口类头部注释
		String comment = GenClassHeadComment.gen(interfaceName, author);
		sb.append(comment);
		// 接口类头部
		String interfaceHeadCode = GenInterface.getHeadCode(interfaceName);
		sb.append(interfaceHeadCode);
		// 生成所有接口方法
		String methodsCode = GenInterface.getCode(parmMap,methods);
		sb.append(methodsCode);
		// 闭合大括号
		sb.append("}");

		return sb.toString();
	}
}
