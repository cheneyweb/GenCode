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
	 * 日期格式化
	 */
	DATE_TIME_24("yyyy-MM-dd HH:mm:ss"),
	
	;

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
