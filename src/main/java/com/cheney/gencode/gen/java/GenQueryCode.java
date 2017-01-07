package com.cheney.gencode.gen.java;

import org.w3c.dom.Document;

import com.cheney.gencode.gen.java.comment.GenClassHeadComment;
import com.cheney.gencode.gen.java.module.GenGlobalConfig;
import com.cheney.gencode.gen.java.module.GenQuery;
import com.cheney.gencode.module.GlobalConfig;
import com.cheney.gencode.module.Query;

/**
 * @Moudle: GenQueryCode
 * @version:v1.0
 * @Description: 生成query代码
 * @author: xuyushuai
 * @date: 2014年10月21日 下午5:29:20
 *
 */
public class GenQueryCode {

	/**
	 * <p>Title: gen</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:52:25</p>
	 * @param document
	 * @return query代码
	 */
	public static String gen(Document document) {
		Query query = GenQuery.getQuery(document);
		if (query == null) {
			return null;
		}
		GlobalConfig globalConfig = GenGlobalConfig.getGlobalConfig(document);

		// 生成Query文件
		String className = globalConfig.getBeanPrefix() + "Query";
		StringBuffer sb = new StringBuffer();
		// 包名
		sb.append("package " + globalConfig.getBasepackage() + ".query;\r\n\r\n");
		// 生成类头部注释
		String comment = GenClassHeadComment.gen(className, globalConfig.getAuthor());
		sb.append(comment);

		// 生成Query类头部
		String classHead = genClassHead(className, query);
		sb.append(classHead);

		// 结尾闭合大括号
		sb.append("}");

		return sb.toString();
	}

	private static String genClassHead(String className, Object object) {
		Query o = (Query) object;
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
