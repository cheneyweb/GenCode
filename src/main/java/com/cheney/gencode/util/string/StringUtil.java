/**
 * @Title: StringUtil.java
 * @Package: com.cheney.stringutil
 * @Description: TODO
 * @author: xuyushuai
 * @date: 2014年10月23日 上午10:05:40
 * @version: V1.0
 */
package com.cheney.gencode.util.string;

import org.springframework.util.StringUtils;

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
     * <p>Title: toLowerCaseFirstOne</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月23日 上午10:08:06</p>
     * 
     * @param s
     * @return 首字母小写的字符串
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     *
     * <p>Title: toUpperCaseFirstOne</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月23日 上午10:06:59</p>
     * 
     * @param s
     * @return 首字母大写的字符串
     */
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    
    /**
    *
    * <p>Title: columnToAttribute</p>
    * <p>author : xuyushuai</p>
    * <p>date : 2014年10月23日 上午10:19:55</p>
    * @param column
    * @param separator
    * @return javabean属性字符串
    */ 
    public static String columnToAttribute(String column, String separator) {
        String attribute = "";
        if (column != null && !column.equals("")) {
            // 如果分隔符存在
            if (separator != null && !separator.equals("")) {
                // 先全部转小写
                column = column.toLowerCase();
                // 根据分隔符拆分
                String[] temp = column.split(separator);
                attribute="";
                for (String s : temp) {
                    attribute += StringUtil.toUpperCaseFirstOne(s);
                }
                attribute = StringUtil.toLowerCaseFirstOne(attribute);
            } else {
                // 首字母小写
                attribute = StringUtil.toLowerCaseFirstOne(column);
            }

        }
        return attribute;
    }
    /**
    *
    * <p>Title: tableNameToClassName</p>
    * <p>author : xuyushuai</p>
    * <p>date : 2014年10月23日 上午10:19:55</p>
    * @param str
    * @param prefix
    * @param separator
    * @return 类名
    */
    public static String tableNameToClassName(String str,String prefix,String separator){
    	String attribute = "";
        if (str != null && !str.equals("")) {
//        	str = str.substring(str.indexOf(prefix)+prefix.length());
            // 如果分隔符存在
            if (!StringUtils.isEmpty(separator)) {
                // 先全部转小写
            	str = str.toLowerCase();
                // 根据分隔符拆分
                String[] temp = str.split(separator);
                attribute="";
                for (String s : temp) {
                    attribute += StringUtil.toUpperCaseFirstOne(s);
                }
                attribute = StringUtil.toLowerCaseFirstOne(attribute);
            } else {
                // 首字母小写
                attribute = StringUtil.toLowerCaseFirstOne(str);
            }
            attribute = StringUtil.toUpperCaseFirstOne(attribute);
        }
        return attribute;
    }
}
