package com.cheney.gencode.gen.java.common;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.cheney.gencode.module.Method;

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
		String moduleName = parmMap.get("moduleName");
		String prefix = parmMap.get("prefix");
		String basepackage = parmMap.get("basepackage");
		String interfaceName = prefix + moduleName;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		parmMap.put("currentTime", df.format(new Date()));
		parmMap.put("serviceName", interfaceName);
		parmMap.put("packageName", basepackage+"."+moduleName.toLowerCase());
		// 根据模板生成代码
		VelocityEngine velocityEngine = new VelocityEngine();
		VelocityContext velocityContext = new VelocityContext();
		StringWriter stringWriter = new StringWriter();
		velocityContext.put("methods", methods);
		velocityContext.put("parmMap", parmMap);
		velocityEngine.mergeTemplate("src/main/resources/templates/code/java/impl.vm", "UTF-8", velocityContext,stringWriter);
		code += stringWriter.toString();
		
		return code;
	}
}
