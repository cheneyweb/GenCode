package com.cheney.gencode.gen.html;

import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class GenFormCode {
	public static String genForm(Map<String, String> parmMap) {
		String code = "";

		VelocityEngine velocityEngine = new VelocityEngine();
		VelocityContext velocityContext = new VelocityContext();
		StringWriter stringWriter = new StringWriter();
		velocityContext.put("type", parmMap.get("type"));
		velocityEngine.mergeTemplate("src/main/resources/templates/code/html/form.vm", "UTF-8", velocityContext,stringWriter);
		code += stringWriter.toString();

		return code;
	}
}
