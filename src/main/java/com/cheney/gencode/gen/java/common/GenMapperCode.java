package com.cheney.gencode.gen.java.common;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.cheney.gencode.module.Method;
import com.cheney.gencode.util.vm.ToolBox;

public class GenMapperCode {
	/**
	 * <p>Title: gen</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:50:19</p>
	 * @param moduleName
	 * @param methods
	 * @return 接口代码
	 */ 
	public static String gen(Map<String, String> parmMap, List<Method> methods) {
		String code = "";

		VelocityEngine velocityEngine = new VelocityEngine();
		VelocityContext velocityContext = new VelocityContext();
		StringWriter stringWriter = new StringWriter();
		velocityContext.put("methods", methods);
		velocityContext.put("parmMap", parmMap);
		velocityContext.put("toolBox", new ToolBox());
		velocityEngine.mergeTemplate("src/main/resources/templates/code/java/mapper_method.vm", "UTF-8",
				velocityContext, stringWriter);
		code += stringWriter.toString();

		return code;
	}
}
