package com.cheney.gencode.util.vm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.cheney.gencode.enums.EnumShortcut;
import com.cheney.gencode.module.Method;

public class ToolBox {
	/**
	 * 首字母小写
	 * @param str
	 * @return 首字母小写字符串
	 */
	public String getLowerFirst(String str){
		return StringUtils.uncapitalize(str);
	}
	/**
	 * 首字母大写
	 * @param str
	 * @return 首字母大写字符串
	 */
	public String getUpperFirst(String str){
		return StringUtils.capitalize(str);
	}
	/**
	 * 格式化日期时间为24小时
	 * @param date
	 * @param format
	 * @return 24小时制的日期时间
	 */
	public String getFormatDate(Date date,String format){
		SimpleDateFormat df = new SimpleDateFormat(EnumShortcut.DATE_TIME_24.getValue());
		return df.format(date);
	}
	/**
	 * 当前时间
	 * @param date
	 * @param format
	 * @return 24小时制的当前时间
	 */
	public String getCurrentTime(){
		SimpleDateFormat df = new SimpleDateFormat(EnumShortcut.DATE_TIME_24.getValue());
		return df.format(new Date());
	}
	
	/**
	 * 获取方法类型，提供给生成MyBatis代码使用
	 * @param methid
	 * @return
	 */
	public String getMethodType(Method methid){
		if(methid.getName().startsWith("insert") || methid.getName().startsWith("add")){
			return "insert";
		}
		if(methid.getName().startsWith("delete") || methid.getName().startsWith("remove")){
			return "delete";
		}
		if(methid.getName().startsWith("update") || methid.getName().startsWith("edit")){
			return "update";
		}
		if(methid.getName().startsWith("select") || methid.getName().startsWith("get") || methid.getName().startsWith("query")){
			return "select";
		}
		return "default";
	}
	
	/**
	 * 获取参数类型，提供给生成MyBatis代码使用
	 * @param inParamMap
	 * @return 方法入参类型
	 */
	public String getParmType(Map<String, String> inParamMap){
		
		for(String key : inParamMap.keySet()){
			// 单参数，判断是List<T>入参还是Map<key,value>入参,还是数组[]入参
			if(inParamMap.size() == 1){
				if(inParamMap.get(key).indexOf("List<") != -1){
					return "list";
				}
				if(inParamMap.get(key).indexOf("Map<") != -1){
					return "map";
				}
				if(inParamMap.get(key).indexOf("[") != -1){
					return "array";
				}
				return "single";
			}
			// 多参数
			return "multi";
		}
		return "";
	}
	/**
	 * 减法操作
	 * @param parm
	 * @param sub
	 * @return 结果
	 */
	public int sub(int parm,int sub){
		return parm - sub;
	}
}
