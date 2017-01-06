package com.cheney.gencode.gen.comment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Moudle: GenMethodComment
 * @version:v1.0
 * @Description: 生成方法的注释
 * @author: xuyushuai
 * @date: 2014年10月24日 下午3:43:43
 *
 */
public class GenMethodComment {

	/**
	 * <p>Title: gen</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:47:37</p>
	 * @param methodName
	 * @param inParamMap
	 * @param returnType
	 * @param author
	 * @return 方法的注释
	 */
	public static String gen(String methodName, Map<String, String> inParamMap, String returnType, String author) {
		String comment = "";
		comment += "\t/**";
		comment += "\t\r\n";
		comment += "\t * <p>Title: ";
		comment += methodName;
		comment += "</p>";
		comment += "\t\r\n";
		comment += "\t * <p>author: ";
		comment += author;
		comment += "</p>";
		comment += "\t\r\n";
		comment += "\t * <p>date: ";
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		comment += df.format(date);
		comment += "</p>";
		comment += "\r\n";
		comment += "\t * ";
		comment += "\r\n";
		for (String inParam : inParamMap.keySet()) {
			comment += "\t * ";
			comment += "@param ";
			comment += inParam;
			comment += " (";
			comment += inParamMap.get(inParam);
			comment += ")";
			comment += "\r\n";
		}
		comment += "\t * ";
		comment += "@return ";
		comment += returnType;
		comment += "\r\n";
		comment += "\t */";
		comment += "\r\n";

		return comment;
	}
}
