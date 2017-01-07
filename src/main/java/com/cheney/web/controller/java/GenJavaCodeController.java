package com.cheney.web.controller.java;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.java.GenServiceCode;
import com.cheney.gencode.gen.module.GenGlobalConfig;
import com.cheney.gencode.module.GlobalConfig;

/**
 * @Moudle: GenJavaCodeController
 * @version:v1.0
 * @Description: Java代码生成器控制入口
 * @author: xuyushuai
 * @date: 2015年3月27日 下午2:08:57
 *
 */
@RestController
@RequestMapping("/gencode/java")
public class GenJavaCodeController {

	@RequestMapping(value="/genservice",method=RequestMethod.POST)
	public Map<String,String> genService(String json, String prefix) {
		initGlobalConfig(prefix);
		json = json.replaceAll("\\s","");
		// 生成接口代码和实现代码
		String interfaceCode = GenServiceCode.genInterface(json);
		String implCode = GenServiceCode.genImpl(json);
		// 返回数据
		Map<String,String> codeMap = new HashMap<String,String>();
		codeMap.put("interfaceCode", interfaceCode);
		codeMap.put("implCode", implCode);

		return codeMap;
	}

	@RequestMapping("/gendao")
	public String genDao(String json, String prefix) {
		return "content/gencode/java/javacode";
	}

	private void initGlobalConfig(String prefix) {
		if (GenGlobalConfig.getGlobalConfig() != null) {
			GenGlobalConfig.getGlobalConfig().setDaoPrefix(prefix);
			GenGlobalConfig.getGlobalConfig().setManagerPrefix(prefix);
			GenGlobalConfig.getGlobalConfig().setServicePrefix(prefix);
		} else {
			GlobalConfig globalConfig = new GlobalConfig();
			globalConfig.setServicePrefix(prefix);
			globalConfig.setManagerPrefix(prefix);
			globalConfig.setDaoPrefix(prefix);
			GenGlobalConfig.setGlobalConfig(globalConfig);
		}
	}

	
}