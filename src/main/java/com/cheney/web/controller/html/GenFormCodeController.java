package com.cheney.web.controller.html;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.html.GenFormCode;

@RestController
@RequestMapping("/gencode/html")
public class GenFormCodeController {
	@RequestMapping(value="/genform",method=RequestMethod.POST)
	public Map<String,String> genForm(String selectedType) {		
		String htmlFormCode = GenFormCode.genForm(selectedType);
//		htmlFormCode = StringEscapeUtils.escapeHtml(htmlFormCode);
		Map<String,String> codeMap = new HashMap<String,String>();
		codeMap.put("htmlFormCode", htmlFormCode);
		codeMap.put("respMsg","Y");
		return codeMap;
	}
}
