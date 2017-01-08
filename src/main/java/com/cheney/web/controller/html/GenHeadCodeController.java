package com.cheney.web.controller.html;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.html.GenHeadCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "HTMLHead")
@RestController
@RequestMapping("/gencode/html")
public class GenHeadCodeController {

	@ApiOperation(value = "生成HTML基础代码", notes = "")
	@RequestMapping(value = "/genhead", method = RequestMethod.POST)
	public Map<String, String> genHead(String type) {
		String htmlHeadCode = GenHeadCode.genHead(type);
		// htmlHeadCode = StringEscapeUtils.escapeHtml(htmlHeadCode);
		Map<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("htmlHeadCode", htmlHeadCode);
		codeMap.put("respMsg", "Y");
		return codeMap;
	}

}
