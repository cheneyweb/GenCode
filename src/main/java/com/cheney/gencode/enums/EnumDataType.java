package com.cheney.gencode.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Moudle: EnumDataType
 * @version:v1.0
 * @Description: 数据类型枚举（用于转换数据库数据类型和Java数据类型）
 * @author: xuyushuai
 * @date: 2014年10月22日 下午6:15:43
 *
 */
public enum EnumDataType {

	/**
	 * NUMBER
	 */
	NUMBER("NUMBER", "Long"),

	/**
	 * CHAR
	 */
	CHAR("CHAR", "String"),

	/**
	 * VARCHAR2
	 */
	VARCHAR2("VARCHAR2", "String"),

	/**
	 * TIMESTAMP
	 */
	TIMESTAMP("TIMESTAMP", "Date");

	private String sqlType;

	private String javaType;

	EnumDataType(String sqlType, String javaType) {
		this.sqlType = sqlType;
		this.javaType = javaType;
	}

	/**
	 * 取得sqlType
	 * 
	 * @return String 处理结果
	 */
	public String getSqlType() {
		return sqlType;
	}

	/**
	 * 设置sqlType
	 * 
	 * @param sqlType
	 */
	public void setSqlType(String sqlType) {
		this.sqlType = sqlType;
	}

	/**
	 * 取得javaType
	 * 
	 * @return String 处理结果
	 */
	public String getJavaType() {
		return javaType;
	}

	/**
	 * 设置javaType
	 * 
	 * @param javaType
	 */
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	/**
	 *
	 * <p>Title: toMap</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2014年10月22日 下午6:25:11</p>
	 * 
	 * @return map
	 */
	public static Map<String, String> toMap() {
		Map<String, String> enumDataMap = new HashMap<String, String>();
		enumDataMap.put(NUMBER.getSqlType(), NUMBER.getJavaType());
		enumDataMap.put(CHAR.getSqlType(), CHAR.getJavaType());
		enumDataMap.put(VARCHAR2.getSqlType(), VARCHAR2.getJavaType());
		enumDataMap.put(TIMESTAMP.getSqlType(), TIMESTAMP.getJavaType());
		return enumDataMap;
	}
}
