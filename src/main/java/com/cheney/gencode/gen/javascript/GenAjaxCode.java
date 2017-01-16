package com.cheney.gencode.gen.javascript;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

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
public class GenAjaxCode {
	/**
	 * <p>Title: genJquery</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年3月27日 下午2:34:42</p>
	 * @return Jquery版本的Ajax代码
	 */
	public static String genJquery(Map<String,String> parmMap) {
		String code = "";
		
		Properties p = new  Properties();
        //这里加载类路径里的模板而不是文件系统路径里的模板
        p.setProperty("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" ); 
		VelocityEngine velocityEngine = new VelocityEngine(p);
		VelocityContext velocityContext = new VelocityContext();
		StringWriter stringWriter = new StringWriter();
		velocityContext.put("type", parmMap.get("type"));
		velocityEngine.mergeTemplate("templates/code/javascript/ajax_jq.vm", "UTF-8", velocityContext,stringWriter);
		code += stringWriter.toString();
		
		return code;
	}

	/**
	 * <p>Title: genJavaScript</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年3月27日 下午2:34:43</p>
	 * @return JavaScript版本的Ajax代码
	 */
	public static String genJavaScript(Map<String,String> parmMap) {
		String code = "";
		
		Properties p = new  Properties();
        //这里加载类路径里的模板而不是文件系统路径里的模板
        p.setProperty("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" ); 
		VelocityEngine velocityEngine = new VelocityEngine(p);
		VelocityContext velocityContext = new VelocityContext();
		StringWriter stringWriter = new StringWriter();
		velocityContext.put("type", parmMap.get("type"));
		velocityEngine.mergeTemplate("templates/code/javascript/ajax_js.vm", "UTF-8", velocityContext,stringWriter);
		code += stringWriter.toString();
		
		return code;
	}
}
