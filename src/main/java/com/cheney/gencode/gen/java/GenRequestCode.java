/**
 * @Title: GenRequestCode.java
 * @Package: com.cheney.gencode
 * @Description: TODO
 * @author: xuyushuai
 * @date: 2014年10月21日 下午5:28:48
 * @version: V1.0
 *//*
package com.cheney.gencode.gen.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import com.cheney.gencode.gen.comment.GenClassHeadComment;
import com.cheney.gencode.gen.module.GenGlobalConfig;
import com.cheney.gencode.gen.module.GenRequest;
import com.cheney.gencode.module.GlobalConfig;
import com.cheney.gencode.module.Request;
import com.cheney.gencode.util.string.StringUtil;

*//**
 * @Moudle: GenRequestCode
 * @version:v1.0
 * @Description: 生成request代码
 * @author: xuyushuai
 * @date: 2014年10月21日 下午5:28:48
 *
 *//*
public class GenRequestCode {

	*//**
	 *
	 * <p>
	 * Title: gen
	 * </p>
	 * <p>
	 * author : xuyushuai
	 * </p>
	 * <p>
	 * date : 2014年10月27日 上午11:45:12
	 * </p>
	 * 
	 * @param document
	 * @throws IOException
	 *//*
	public static List<String> gen(Document document) {
		Request request = GenRequest.getRequest(document);
		if (request == null) {
			return null;
		}

		GlobalConfig globalConfig = GenGlobalConfig.getGlobalConfig(document);

		// 获取request的名称列表
		List<String> requestNames = request.getNames();
		List<String> requestCodeList = new ArrayList<String>();
		// 循环生成每个Request文件
		for (String requestName : requestNames) {
			requestName = StringUtil.toUpperCaseFirstOne(requestName) + "Request";
			StringBuffer sb = new StringBuffer();

			// 包名
			sb.append("package " + globalConfig.getBasepackage() + ".req;\r\n\r\n");
			// 生成类头部注释
			String comment = GenClassHeadComment.gen(requestName, globalConfig.getAuthor());
			sb.append(comment);
			// 生成request头部
			String classHead = genClassHead(requestName, request);
			sb.append(classHead);

			// 结尾闭合大括号
			sb.append("}");

			requestCodeList.add(sb.toString());
		}
		return requestCodeList;
	}

	private static String genClassHead(String className, Object object) {
		Request o = (Request) object;
		String code = "";
		code += "public class ";
		code += className;
		if (o.getExtendsClass() != null && !o.getExtendsClass().equals("")) {
			code += " extends ";
			code += o.getExtendsClass();
		}
		if (o.getImplementsInterface() != null && !o.getImplementsInterface().equals("")) {
			code += " implements ";
			code += o.getImplementsInterface();
		}
		code += "{";
		code += "\r\n";
		code += "\r\n";

		return code;
	}
}
*/