package com.cheney.web.controller.regex;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * @Moudle: GenReplaceCodeController
 * @version:v1.0
 * @Description: 正则表达式替换代码生成器控制入口
 * @author: xuyushuai
 * @date: 2015年6月6日 上午11:12:57
 *
 */
@Api(tags = "RegexReplace")
@RestController
@RequestMapping("/gencode/regex")
public class GenReplaceCodeController {

	@RequestMapping(value = "/genreplace", method = RequestMethod.POST)
	public Map<String, String> genReplace(String type, ModelMap model) {
		Map<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("code", "建设中...");
		return codeMap;
	}
}