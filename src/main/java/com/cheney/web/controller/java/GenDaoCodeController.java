package com.cheney.web.controller.java;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.java.GenDaoCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Moudle: GenDaoCodeController
 * @version:v1.0
 * @Description: Java代码生成器控制入口
 * @author: xuyushuai
 * @date: 2015年3月27日 下午2:08:57
 *
 */
@Api(tags = "JAVADao")
@RestController
@RequestMapping("/gencode/java")
public class GenDaoCodeController {

	@ApiOperation(value = "生成JavaDap代码", notes = "")
	@RequestMapping(value = "/gendao", method = RequestMethod.POST)
	public Map<String, String> genDao(String prefix, String json) {
		// 入参设置
		json = json.replaceAll("\\s", "");
		Map<String, String> parmMap = new HashMap<String, String>();
		parmMap.put("prefix", prefix);
		parmMap.put("json", json);
		// 生成接口代码和实现代码
		String interfaceCode = GenDaoCode.genInterface(parmMap);
		String mapperCode = GenDaoCode.genMapper(parmMap);
		// 返回数据
		Map<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("interfaceCode", interfaceCode);
		codeMap.put("mapperCode", mapperCode);

		return codeMap;
	}
}