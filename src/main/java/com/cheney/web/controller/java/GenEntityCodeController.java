package com.cheney.web.controller.java;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.java.GenEntityCode;

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
	public Map<String,String> genDto(String prefix, String extendsClass, String implementsInterface, String createTableSql, String columnCommentSql, HttpServletResponse response) {
		// 入参设置
		Map<String,String> parmMap = new HashMap<String,String>();
		parmMap.put("beanPrefix",prefix);
		parmMap.put("extendsClass",extendsClass);
		parmMap.put("implementsInterface",implementsInterface);
		parmMap.put("basepackage","");
		parmMap.put("author","");
		parmMap.put("createTableSql",createTableSql);
		parmMap.put("columnCommentSql",columnCommentSql);
		// 生成实体代码
		Map<String,String> resultMap = GenEntityCode.gen(parmMap);
		return resultMap;
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