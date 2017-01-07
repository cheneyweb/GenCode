package com.cheney.gencode.gen.java.common;

import java.util.Map;

import com.cheney.gencode.enums.EnumShortcut;
import com.cheney.gencode.util.string.StringUtil;

/**
 * @Moudle: GenAttributeCode 
 * @version:v1.0
 * @Description: 生成Bean的属性代码
 * @author: xuyushuai
 * @date: 2015年5月4日 上午10:42:00
 *
 */
public class GenAttributeCode {
	/**
	 * <p>Title: genAttributeCode</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:42:02</p>
	 * @param tableMap
	 * @param dataTypeMap
	 * @param column
	 * @return Bean的属性代码
	 */
	public static String gen(Map<String, String> tableMap, Map<String, String> dataTypeMap, String column) {
		String code = "";
		code += EnumShortcut.TAB.getValue();
		code += "private ";
		// 生成数据类型
		String javaType = dataTypeMap.get(tableMap.get(column));
		if (javaType == null) {
			javaType = "Date";
		}
		code += javaType;
		code += " ";
		code += StringUtil.columnToAttribute(column, "_");
		code += ";";
		code += EnumShortcut.NL2.getValue();
		return code;
	}
}
