/**
 * @Title: GenResponseCode.java
 * @Package: com.cheney.gencode
 * @Description: TODO
 * @author: xuyushuai
 * @date: 2014年10月21日 下午5:28:58
 * @version: V1.0
 *//*
package com.cheney.gencode.gen.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import com.cheney.gencode.gen.comment.GenClassHeadComment;
import com.cheney.gencode.gen.module.GenGlobalConfig;
import com.cheney.gencode.gen.module.GenResponse;
import com.cheney.gencode.module.GlobalConfig;
import com.cheney.gencode.module.Response;
import com.cheney.gencode.util.string.StringUtil;

*//**
 * @Moudle: GenResponseCode
 * @version:v1.0
 * @Description: 生成response代码
 * @author: xuyushuai
 * @date: 2014年10月21日 下午5:28:58
 *
 *//*
public class GenResponseCode {

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
		Response response = GenResponse.getResponse(document);
		if (response == null) {
			return null;
		}
		GlobalConfig globalConfig = GenGlobalConfig.getGlobalConfig(document);

		// 获取response名称列表
		List<String> responseNames = response.getNames();
		List<String> responseCodeList = new ArrayList<String>();

		// 循环生成每个Response文件
		for (String responseName : responseNames) {
			responseName = StringUtil.toUpperCaseFirstOne(responseName) + "Response";
			StringBuffer sb = new StringBuffer();

			// 包名
			sb.append("package " + globalConfig.getBasepackage() + ".resp;\r\n\r\n");
			// 生成类头部注释
			String comment = GenClassHeadComment.gen(responseName, globalConfig.getAuthor());
			sb.append(comment);

			// 生成Response头部
			String classHead = genClassHead(responseName, response);
			sb.append(classHead);

			// 结尾闭合大括号
			sb.append("}");

			responseCodeList.add(sb.toString());
		}
		return responseCodeList;
	}

	private static String genClassHead(String className, Object object) {
		Response o = (Response) object;
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