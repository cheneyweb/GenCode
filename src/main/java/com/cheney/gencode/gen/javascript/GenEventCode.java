package com.cheney.gencode.gen.javascript;

import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

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
	public static String genJquery(Map<String, String> parmMap) {
String code = "";
		
		VelocityEngine velocityEngine = new VelocityEngine();
		VelocityContext velocityContext = new VelocityContext();
		StringWriter stringWriter = new StringWriter();
		velocityContext.put("type", parmMap.get("type"));
		velocityEngine.mergeTemplate("src/main/resources/templates/code/javascript/event_jq.vm", "UTF-8", velocityContext,stringWriter);
		code += stringWriter.toString();
		
		return code;
	}

	/**
	 * <p>Title: genJavaScript</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年3月27日 下午2:34:43</p>
	 * @return JavaScript版本的Ajax代码
	 */
	public static String genJavaScript(Map<String, String> parmMap) {
String code = "";
		
		VelocityEngine velocityEngine = new VelocityEngine();
		VelocityContext velocityContext = new VelocityContext();
		StringWriter stringWriter = new StringWriter();
		velocityContext.put("type", parmMap.get("type"));
		velocityEngine.mergeTemplate("src/main/resources/templates/code/javascript/event_js.vm", "UTF-8", velocityContext,stringWriter);
		code += stringWriter.toString();
		
		return code;
	}
}
