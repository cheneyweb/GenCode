package com.cheney.web.controller.javascript;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.javascript.GenAjaxCode;

/**
 * @Moudle: GenAjaxCodeController
 * @version:v1.0
 * @Description: Ajax代码生成器控制入口
 * @author: xuyushuai
 * @date: 2015年3月27日 下午2:08:57
 *
 */
@RestController
@RequestMapping("/gencode/javascript")
public class GenAjaxCodeController {
	@RequestMapping(value="/gencode",method=RequestMethod.POST)
	public Map<String,String> genGet(String selectedType) {
		String jqueryAjaxCode = GenAjaxCode.genJquery(selectedType);
		String javaScriptAjaxCode = GenAjaxCode.genJavaScript(selectedType);
		Map<String,String> codeMap = new HashMap<String,String>();
		codeMap.put("jqueryAjaxCode", jqueryAjaxCode);
		codeMap.put("javaScriptAjaxCode", javaScriptAjaxCode);
		return codeMap;
	}
}