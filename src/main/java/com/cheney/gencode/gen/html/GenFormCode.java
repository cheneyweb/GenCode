package com.cheney.gencode.gen.html;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class GenFormCode {
	public static String genForm(Map<String, String> parmMap) {
		String code = "";
		
		Properties p = new  Properties();
        //这里加载类路径里的模板而不是文件系统路径里的模板
        p.setProperty("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" ); 
		VelocityEngine velocityEngine = new VelocityEngine(p);
		VelocityContext velocityContext = new VelocityContext();
		StringWriter stringWriter = new StringWriter();
		velocityContext.put("type", parmMap.get("type"));
		velocityEngine.mergeTemplate("templates/code/html/form.vm", "UTF-8", velocityContext,stringWriter);
		code += stringWriter.toString();

		return code;
	}
}
