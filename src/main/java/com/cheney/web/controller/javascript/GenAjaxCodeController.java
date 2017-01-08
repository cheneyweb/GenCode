package com.cheney.web.controller.javascript;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.javascript.GenAjaxCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Moudle: GenAjaxCodeController
 * @version:v1.0
 * @Description: Ajax代码生成器控制入口
 * @author: xuyushuai
 * @date: 2015年3月27日 下午2:08:57
 *
 */
@Api(tags = "JavaScriptAjax")
@RestController
@RequestMapping("/gencode/javascript")
public class GenAjaxCodeController {

	@ApiOperation(value = "生成AJAX代码", notes = "")
	@RequestMapping(value = "/gencode", method = RequestMethod.POST)
	public Map<String, String> genGet(String selectedType) {
		String jqueryAjaxCode = GenAjaxCode.genJquery(selectedType);
		String javaScriptAjaxCode = GenAjaxCode.genJavaScript(selectedType);
		Map<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("jqueryAjaxCode", jqueryAjaxCode);
		codeMap.put("javaScriptAjaxCode", javaScriptAjaxCode);
		return codeMap;
	}
}