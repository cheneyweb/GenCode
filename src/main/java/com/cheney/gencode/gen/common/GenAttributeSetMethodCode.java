package com.cheney.gencode.gen.common;

import java.util.Map;

import com.cheney.gencode.enums.EnumShortcut;
import com.cheney.gencode.util.string.StringUtil;

/**
 * @Moudle: GenAttributeSetMethodCode 
 * @version:v1.0
 * @Description: 生成Bean的属性的Set方法代码
 * @author: xuyushuai
 * @date: 2015年5月4日 上午10:43:04
 *
 */
public class GenAttributeSetMethodCode {
	/**
	 * <p>Title: gen</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:43:06</p>
	 * @param tableMap
	 * @param dataTypeMap
	 * @param column
	 * @return Bean的属性的Set方法代码
	 */
	public static String gen(Map<String, String> tableMap, Map<String, String> dataTypeMap, String column) {
		String code = "";
		code += EnumShortcut.TAB.getValue();
		code += "public ";
		// 生成方法
		code += "void set";
		code += StringUtil.toUpperCaseFirstOne(StringUtil.columnToAttribute(column, "_"));
		code += "(";
		// 生成入参
		String javaType = dataTypeMap.get(tableMap.get(column));
		if (javaType == null) {
			javaType = "Date";
		}
		code += javaType;
		code += " ";
		code += StringUtil.columnToAttribute(column, "_");
		code += "){";
		// 生成方法体
		code += EnumShortcut.NL.getValue();
		code += EnumShortcut.TAB2.getValue();
		code += " this.";
		code += StringUtil.columnToAttribute(column, "_");
		code += " = ";
		code += StringUtil.columnToAttribute(column, "_");
		code += ";";
		code += EnumShortcut.NL.getValue();
		code += EnumShortcut.TAB.getValue();
		code += "}";
		code += EnumShortcut.NL.getValue();
		return code;
	}
}
