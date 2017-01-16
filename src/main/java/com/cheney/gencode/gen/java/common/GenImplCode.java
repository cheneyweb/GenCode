package com.cheney.gencode.gen.java.common;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.cheney.gencode.module.Method;
import com.cheney.gencode.util.vm.ToolBox;

/**
 * @Moudle: GenImplCode 
 * @version:v1.0
 * @Description: 生成接口的实现代码
 * @author: xuyushuai
 * @date: 2015年5月4日 上午10:49:08
 *
 */
public class GenImplCode {
	/**
	 * <p>Title: gen</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:49:10</p>
	 * @param moduleName
	 * @param methods
	 * @return 接口的实现代码
	 */
	public static String gen(Map<String,String> parmMap, List<Method> methods) {
		String code = "";
		// 入参设置
		String basepackage = parmMap.get("basepackage");
		String prefix = parmMap.get("prefix");
		String moduleName = parmMap.get("moduleName");
		// 类名
		String serviceName = prefix + moduleName;
		parmMap.put("serviceName", serviceName);
		// 包名
		parmMap.put("packageName", basepackage+"."+moduleName.toLowerCase());
		// 根据模板生成代码
		Properties p = new  Properties();
        //这里加载类路径里的模板而不是文件系统路径里的模板
        p.setProperty("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" ); 
		VelocityEngine velocityEngine = new VelocityEngine(p);
		VelocityContext velocityContext = new VelocityContext();
		StringWriter stringWriter = new StringWriter();
		velocityContext.put("methods", methods);
		velocityContext.put("parmMap", parmMap);
		velocityContext.put("toolBox", new ToolBox());
		velocityEngine.mergeTemplate("templates/code/java/impl.vm", "UTF-8", velocityContext,stringWriter);
		code += stringWriter.toString();
		
		return code;
	}
}
