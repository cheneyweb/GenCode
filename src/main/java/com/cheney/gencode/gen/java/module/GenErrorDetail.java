package com.cheney.gencode.gen.java.module;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.ModelMap;

/**
 * @Moudle: GenErrorDetail 
 * @version:v1.0
 * @Description: 全局错误存储
 * @author: xuyushuai
 * @date: 2015年4月30日 上午10:13:53
 *
 */
public class GenErrorDetail {

	/**
	 * 全局错误存储，Map<错误号，错误详情>
	 */
	private static Map<String, String> errorMap;

	/**
	 * <p>Title: 追加错误信息</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月3日 上午11:27:58</p>
	 * @param key
	 * @param value
	 */
	public static void put(String key, String value) {
		errorMap.put(key, value);
	}

	/**
	 * <p>Title: 获取错误信息map（只用于最终获取，获取后错误信息会清空）</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月3日 上午11:28:17</p>
	 * @return
	 */
	public static Map<String, String> getErrorMap() {
		@SuppressWarnings("unchecked")
		Map<String, String> cloneMap = (Map<String, String>) ((HashMap<String, String>) errorMap).clone();
		errorMap.clear();
		return cloneMap;
	}

	/**
	 * <p>Title: 设置错误信息Map（用于初始化）</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月3日 上午11:28:53</p>
	 * @param errorMap
	 */
	public static void setErrorMap(Map<String, String> errorMap) {
		GenErrorDetail.errorMap = errorMap;
	}

	/**
	 * <p>Title: 判断是否存在错误</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月3日 上午11:29:15</p>
	 * @return
	 */
	public static boolean hasError() {
		if (errorMap.size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <p>Title: 清空错误信息Map</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月3日 上午11:29:33</p>
	 */
	public static void clearErrorMap() {
		GenErrorDetail.errorMap.clear();
	}

	/**
	 * <p>Title: 处理错误信息，返回错误页</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月3日 上午11:29:55</p>
	 * @param model
	 * @return
	 */
	public static String errorProcess(ModelMap model) {
		model.addAttribute("errorMap", GenErrorDetail.getErrorMap());
		return "content/error/error";
	}

}
