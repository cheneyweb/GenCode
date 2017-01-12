package com.cheney.gencode.util.string;

import org.apache.commons.lang.StringUtils;

/**
 * @Moudle: StringUtil
 * @version:v1.0
 * @Description: 字符串处理工具
 * @author: xuyushuai
 * @date: 2014年10月23日 上午10:05:40
 *
 */
public class StringUtil {    
    /**
    *
    * <p>Title: columnToAttribute</p>
    * <p>author : xuyushuai</p>
    * <p>date : 2014年10月23日 上午10:19:55</p>
    * @param column 数据库列名
    * @param separator 分隔符
    * @return javabean属性字符串
    */ 
	public static String columnToAttribute(String column, String separator) {
		String attribute = "";
		// 如果分隔符存在
		if (StringUtils.isNotEmpty(column) && StringUtils.isNotEmpty(separator)) {
			// 先全部转小写
			column = column.toLowerCase();
			// 根据分隔符拆分
			String[] temp = column.split(separator);
			attribute = "";
			for (String s : temp) {
				attribute += StringUtils.capitalize(s);
			}
			// 首字母小写
			attribute = StringUtils.uncapitalize(column);
		}
		return attribute;
	}
    /**
    *
    * <p>Title: tableNameToClassName</p>
    * <p>author : xuyushuai</p>
    * <p>date : 2014年10月23日 上午10:19:55</p>
    * @param str 输入字符串
    * @param prefix 需要去除的前缀
    * @param separator 分隔符
    * @return 类名
    */
	public static String tableNameToClassName(String str, String prefix, String separator) {
		String attribute = "";
		// 如果分隔符存在
		if (StringUtils.isNotEmpty(str) && StringUtils.isNotEmpty(separator)) {
			// 去除前缀
			if(StringUtils.isNotEmpty(prefix)){
				int beginIndex = str.indexOf(prefix);
				if (beginIndex != -1) {
					str = str.substring(beginIndex + prefix.length());
				}
			}
			// 先全部转小写
			str = str.toLowerCase();
			// 根据分隔符拆分
			String[] temp = str.split(separator);
			attribute = "";
			for (String s : temp) {
				attribute += StringUtils.capitalize(s);
			}
		}
		// 首字母大写
		attribute = StringUtils.capitalize(attribute);
		return attribute;
	}
}
