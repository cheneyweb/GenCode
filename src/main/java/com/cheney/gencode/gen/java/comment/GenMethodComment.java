package com.cheney.gencode.gen.java.comment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.cheney.gencode.enums.EnumShortcut;

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
		comment += EnumShortcut.TAB.getValue();
		comment += "/**";
		comment += EnumShortcut.TAB.getValue();
		comment += EnumShortcut.NL.getValue();
		comment += EnumShortcut.TAB.getValue();
		comment += " * <p>Title: ";
		comment += methodName;
		comment += "</p>";
		comment += EnumShortcut.TAB.getValue();
		comment += EnumShortcut.NL.getValue();
		comment += EnumShortcut.TAB.getValue();
		comment += " * <p>author: ";
		comment += author;
		comment += "</p>";
		comment += EnumShortcut.TAB.getValue();
		comment += EnumShortcut.NL.getValue();
		comment += EnumShortcut.TAB.getValue();
		comment += " * <p>date: ";
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		comment += df.format(date);
		comment += "</p>";
		comment += EnumShortcut.NL.getValue();
		comment += EnumShortcut.TAB.getValue();
		comment += " * ";
		comment += EnumShortcut.NL.getValue();
		for (String inParam : inParamMap.keySet()) {
			comment += EnumShortcut.TAB.getValue();
			comment += " * ";
			comment += "@param ";
			comment += inParam;
			comment += " (";
			comment += inParamMap.get(inParam);
			comment += ")";
			comment += EnumShortcut.NL.getValue();
		}
		comment += EnumShortcut.TAB.getValue();
		comment += " * ";
		comment += "@return ";
		comment += returnType;
		comment += EnumShortcut.NL.getValue();
		comment += EnumShortcut.TAB.getValue();
		comment += " */";
		comment += EnumShortcut.NL.getValue();

		return comment;
	}
}
