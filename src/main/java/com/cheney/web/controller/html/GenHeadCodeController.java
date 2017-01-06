package com.cheney.web.controller.html;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.html.GenHeadCode;

@RestController
@RequestMapping("/gencode/html")
public class GenHeadCodeController {
	@RequestMapping("/genhead")
	public Map<String,String> genHead(String type) {
		String htmlHeadCode = GenHeadCode.genHead(type);
//		htmlHeadCode = StringEscapeUtils.escapeHtml(htmlHeadCode);
		Map<String,String> codeMap = new HashMap<String,String>();
		codeMap.put("htmlHeadCode", htmlHeadCode);
		codeMap.put("respMsg","Y");
		return codeMap;
	}

}
