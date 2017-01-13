package com.cheney.web.controller.java;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.java.GenEntityCode;
import com.cheney.gencode.gen.java.module.GenGlobalConfig;
import com.cheney.gencode.module.GlobalConfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Moudle: GenDtoCodeController 
 * @version:v1.0
 * @Description: DTO生成控制器入口
 * @author: xuyushuai
 * @date: 2015年4月28日 上午11:25:43
 *
 */
@Api(tags = "JAVAEntity")
@RestController
@RequestMapping("/gencode/java")
public class GenEntityCodeController {
	
	@ApiOperation(value = "生成Java实体代码", notes = "")
	@RequestMapping(value="/genentity",method=RequestMethod.POST)
	public Map<String,String> genDto(String json, String createTableSql, String columnCommentSql, @CookieValue(value="globalconfig",defaultValue="") String globalconfig) {
		// 从cookie获取系统配置
		globalconfig = new String(Base64.decodeBase64(globalconfig.getBytes()));
		GlobalConfig globalConfig = GenGlobalConfig.getGlobalConfig(globalconfig);
		// 入参设置
		json = json.replaceAll("\\s", "");
		Map<String,String> parmMap = new HashMap<String,String>();
		parmMap.put("json",json);
		parmMap.put("basepackage",globalConfig.getBasepackage());
		parmMap.put("author",globalConfig.getAuthor());
		parmMap.put("createTableSql",createTableSql);
		parmMap.put("columnCommentSql",columnCommentSql);
		// 生成实体类代码和Mapper代码
		String classCode = GenEntityCode.genClass(parmMap);
		String mapperCode = GenEntityCode.genMapper(parmMap);
		// 生成Mapper代码
		Map<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("classCode", classCode);
		codeMap.put("mapperCode", mapperCode);
		return codeMap;
	}


//	private void initGlobalConfig(String beanPrefix, String extendsClass, String implementsInterface, HttpServletResponse response) {
//
//		GenGlobalConfig.getGlobalConfig().setBeanPrefix(beanPrefix);
//		GenGlobalConfig.getGlobalConfig().setExtendsClass(extendsClass);
//		GenGlobalConfig.getGlobalConfig().setImplementsInterface(implementsInterface);
//
//		Cookie c1 = new Cookie("beanprefix", beanPrefix);
//		c1.setMaxAge(30 * 24 * 60 * 60);
//		response.addCookie(c1);
//		Cookie c2 = new Cookie("extendsclass", extendsClass);
//		c2.setMaxAge(30 * 24 * 60 * 60);
//		response.addCookie(c2);
//		Cookie c3 = new Cookie("implementsinterface", implementsInterface);
//		c3.setMaxAge(30 * 24 * 60 * 60);
//		response.addCookie(c3);
//	}
}