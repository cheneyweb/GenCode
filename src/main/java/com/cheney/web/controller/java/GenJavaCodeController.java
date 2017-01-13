package com.cheney.web.controller.java;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.java.GenServiceCode;
import com.cheney.gencode.gen.java.module.GenGlobalConfig;
import com.cheney.gencode.module.GlobalConfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Moudle: GenJavaCodeController
 * @version:v1.0
 * @Description: Java代码生成器控制入口
 * @author: xuyushuai
 * @date: 2015年3月27日 下午2:08:57
 *
 */
@Api(tags = "JAVAService")
@RestController
@RequestMapping("/gencode/java")
public class GenJavaCodeController {

	@ApiOperation(value = "生成Java业务层代码", notes = "")
	@RequestMapping(value = "/genservice", method = RequestMethod.POST)
	public Map<String, String> genService(String prefix, String json,@CookieValue(value="globalconfig",defaultValue="") String globalconfig) {
		// 从cookie获取系统配置
		globalconfig = new String(Base64.decodeBase64(globalconfig.getBytes()));
		GlobalConfig globalConfig = GenGlobalConfig.getGlobalConfig(globalconfig);
		// 入参设置
		json = json.replaceAll("\\s", "");
		Map<String, String> parmMap = new HashMap<String, String>();
		parmMap.put("prefix", prefix);
		parmMap.put("json", json);
		parmMap.put("basepackage",globalConfig.getBasepackage());
		parmMap.put("author",globalConfig.getAuthor());
		// 生成接口代码和实现代码
		String interfaceCode = GenServiceCode.genInterface(parmMap);
		String implCode = GenServiceCode.genImpl(parmMap);
		// 返回数据
		Map<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("interfaceCode", interfaceCode);
		codeMap.put("implCode", implCode);

		return codeMap;
	}
}