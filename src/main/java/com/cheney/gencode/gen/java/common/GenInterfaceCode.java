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
 * @Moudle: GenInterfaceCode
 * @version:v1.0
 * @Description: 生成接口代码
 * @author: xuyushuai
 * @date: 2015年3月26日 上午11:51:03
 *
 */
public class GenInterfaceCode {
	/**
	 * <p>Title: gen</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:50:19</p>
	 * @param moduleName
	 * @param methods
	 * @return 接口代码
	 */ 
	public static String gen(Map<String,String> parmMap,List<Method> methods) {
		String code = "";
		// 入参设置
		String moduleName = parmMap.get("moduleName");
		String prefix = parmMap.get("prefix");
		String basepackage = parmMap.get("basepackage");
		String interfaceName = prefix + moduleName;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		parmMap.put("currentTime", df.format(new Date()));
		parmMap.put("interfaceName", interfaceName);
		parmMap.put("packageName", basepackage+"."+moduleName.toLowerCase());
		// 根据模板生成代码
		VelocityEngine velocityEngine = new VelocityEngine();
		VelocityContext velocityContext = new VelocityContext();
		StringWriter stringWriter = new StringWriter();
		velocityContext.put("methods", methods);
		velocityContext.put("parmMap", parmMap);
		velocityEngine.mergeTemplate("src/main/resources/templates/code/java/interface.vm", "UTF-8", velocityContext,stringWriter);
		code += stringWriter.toString();
		
		return code;
	}
}
