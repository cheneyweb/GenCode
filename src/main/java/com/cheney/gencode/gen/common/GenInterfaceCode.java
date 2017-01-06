package com.cheney.gencode.gen.common;

import java.util.List;

import com.cheney.gencode.gen.comment.GenClassHeadComment;
import com.cheney.gencode.gen.module.GenGlobalConfig;
import com.cheney.gencode.module.GlobalConfig;
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
	public static String gen(String moduleName,List<Method> methods) {
		
		GlobalConfig globalConfig = GenGlobalConfig.getGlobalConfig();
		// 生成Service接口文件
		String interfaceName = globalConfig.getServicePrefix() + moduleName;

		StringBuffer sb = new StringBuffer();

		// 包名
		sb.append("package " + globalConfig.getBasepackage() + "."+moduleName.toLowerCase()+";\r\n\r\n");
		// 接口类头部注释
		String comment = GenClassHeadComment.gen(interfaceName, globalConfig.getAuthor());
		sb.append(comment);
		// 接口类头部
		String interfaceHeadCode = GenInterface.getHeadCode(interfaceName);
		sb.append(interfaceHeadCode);
		// 生成所有接口方法
		String methodsCode = GenInterface.getCode(methods, globalConfig);
		sb.append(methodsCode);
		// 闭合大括号
		sb.append("}");

		return sb.toString();
	}
}
