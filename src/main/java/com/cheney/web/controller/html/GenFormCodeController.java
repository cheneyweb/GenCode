package com.cheney.web.controller.html;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.html.GenFormCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="HTMLForm")
@RestController
@RequestMapping("/gencode/html")
public class GenFormCodeController {
	
	@ApiOperation(value = "生成表单代码", notes = "")
	@RequestMapping(value = "/genform", method = RequestMethod.POST)
	public Map<String, String> genForm(String selectedType) {
		// 入参设置
		Map<String, String> parmMap = new HashMap<String,String>();
		parmMap.put("type", selectedType);
		// 表单代码生成
		String htmlFormCode = GenFormCode.genForm(parmMap);
		// 返回数据
		Map<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("htmlFormCode", htmlFormCode);
		codeMap.put("respMsg", "Y");
		return codeMap;
	}
}
