package com.cheney.gencode.util.vm;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.cheney.gencode.enums.EnumShortcut;

public class ToolBox {
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
}
