package com.cheney.gencode.enums;

/**
 * @Moudle: EnumShortcut
 * @version:v1.0
 * @Description: 快捷键枚举（用于定义特殊字符文本）
 * @author: xuyushuai
 * @date: 2017年1月5日 16:10:43
 *
 */
public enum EnumShortcut {

	/**
	 * 回车换行
	 */
	NL("\r\n"),
	
	/**
	 * 回车换行
	 */
	NL2("\r\n\r\n"),
	
	/**
	 * 回车换行
	 */
	NL3("\r\n\r\n\r\n"),
	
	/**
	 * 回车换行
	 */
	NL4("\r\n\r\n\r\n\r\n"),

	/**
	 * 制表符
	 */
	TAB("\t"),
	
	/**
	 * 制表符
	 */
	TAB2("\t\t"),
	
	/**
	 * 制表符
	 */
	TAB3("\t\t\t"),
	
	/**
	 * 制表符
	 */
	TAB4("\t\t\t\t");

	private String value;

	EnumShortcut(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
