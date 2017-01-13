package com.cheney.web.controller.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.java.module.GenGlobalConfig;
import com.cheney.gencode.module.GlobalConfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="GlobalConfig")
@RestController
@RequestMapping("/config")
public class ConfigController {
	@ApiOperation(value = "获取系统配置", notes = "")
	@RequestMapping(value="/getglobal",method=RequestMethod.POST)
	public Map<String,String> saveGlobal(String json,@CookieValue(value="globalconfig",defaultValue="") String globalconfig) {
		Map<String,String> resultMap = new HashMap<String,String>();
		if(StringUtils.isNotEmpty(globalconfig)){
			globalconfig = new String(Base64.decodeBase64(globalconfig.getBytes()));
			resultMap.put("globalconfig", globalconfig);
			resultMap.put("respMsg", "Y");
		}else{
			resultMap.put("respMsg", "系统配置不存在");
		}
		return resultMap;
	}
	
	@ApiOperation(value = "保存系统配置", notes = "")
	@RequestMapping(value="/saveglobal",method=RequestMethod.POST)
	public Map<String,String> saveGlobal(String json,HttpServletResponse response) {
		Map<String,String> resultMap = new HashMap<String,String>();
		json = json.replaceAll("\\s", "");
		// 将入参JSON进行BASE64编码
		json = new String(Base64.encodeBase64(json.getBytes()));
		// 解码后测试是否能生成系统配置对象
		String jsonConfig = new String(Base64.decodeBase64(json.getBytes()));
		GlobalConfig globalConfig = GenGlobalConfig.getGlobalConfig(jsonConfig);
		if(globalConfig != null){
			// 保存json到cookie中
			Cookie c = new Cookie("globalconfig", json);
			c.setPath("/");
			c.setMaxAge(30 * 24 * 60 * 60);
			response.addCookie(c);
			resultMap.put("respMsg", "Y");
		}else{
			resultMap.put("respMsg", "配置JSON不正确");
		}
		return resultMap;
	}
}
