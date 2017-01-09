package com.cheney.web.controller.javascript;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.javascript.GenEventCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Moudle: GenEventCodeController
 * @version:v1.0
 * @Description: JavaScript Event代码生成器控制入口
 * @author: xuyushuai
 * @date: 2015年3月27日 下午2:08:57
 *
 */
@Api(tags = "JavaScriptEvent")
@RestController
@RequestMapping("/gencode/javascript")
public class GenEventCodeController {

	@ApiOperation(value = "生成Event代码", notes = "")
	@RequestMapping(value="/genevent",method = RequestMethod.POST)
	public Map<String,String> genClick(String selectedType) {
		// 入参设置
		Map<String, String> parmMap = new HashMap<String,String>();
		parmMap.put("type", selectedType);
		// 事件代码生成
		String jqueryEventCode = GenEventCode.genJquery(parmMap);
		String javaScriptEventCode = GenEventCode.genJavaScript(parmMap);
		Map<String,String> codeMap = new HashMap<String,String>();
		// 返回数据
		codeMap.put("jqueryAjaxCode", jqueryEventCode);
		codeMap.put("javaScriptAjaxCode", javaScriptEventCode);
		return codeMap;
	}
}