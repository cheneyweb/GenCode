package com.cheney.gencode.gen.javascript;

/**
 * @Moudle: GenAjaxCode 
 * @version:v1.0
 * @Description: Ajax代码生成器
 * @author: xuyushuai
 * @date: 2015年3月27日 下午2:34:40
 *
 */
public class GenEventCode {
	/**
	 * <p>Title: genJquery</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年3月27日 下午2:34:42</p>
	 * @return Jquery版本的Ajax代码
	 */
	public static String genJquery(String type) {
		String jqueryEventCode = "$('').";
		jqueryEventCode += type;
		jqueryEventCode += "(function(){";
		jqueryEventCode += "\r\n";
		jqueryEventCode += "});";
		return jqueryEventCode;
	}

	/**
	 * <p>Title: genJavaScript</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年3月27日 下午2:34:43</p>
	 * @return JavaScript版本的Ajax代码
	 */
	public static String genJavaScript(String type) {
		String javaScriptEventCode = "document.getElementById('').on";
		javaScriptEventCode += type;
		javaScriptEventCode += "=function(){";
		javaScriptEventCode += "\r\n";
		javaScriptEventCode += "};";
		return javaScriptEventCode;
	}
}
