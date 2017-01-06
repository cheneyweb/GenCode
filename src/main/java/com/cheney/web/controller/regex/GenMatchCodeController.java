package com.cheney.web.controller.regex;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Moudle: GenMatchCodeController
 * @version:v1.0
 * @Description: 正则表达式匹配代码生成器控制入口
 * @author: xuyushuai
 * @date: 2015年6月6日 上午11:12:57
 *
 */
@RestController
@RequestMapping("/gencode/regex")
public class GenMatchCodeController {

	@RequestMapping("/genmatch")
	public Map<String,String> genMatch(String type) {
		Map<String,String> codeMap = new HashMap<String,String>();
		codeMap.put("code", "建设中...");
		return codeMap;
	}
}