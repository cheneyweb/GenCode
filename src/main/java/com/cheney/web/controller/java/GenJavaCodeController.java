package com.cheney.web.controller.java;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import com.cheney.gencode.gen.java.GenDaoCode;
import com.cheney.gencode.gen.java.GenManagerCode;
import com.cheney.gencode.gen.java.GenServiceCode;
import com.cheney.gencode.gen.module.GenErrorDetail;
import com.cheney.gencode.gen.module.GenGlobalConfig;
import com.cheney.gencode.module.GlobalConfig;
import com.cheney.gencode.util.xml.XMLParseUtil;

/**
 * @Moudle: GenJavaCodeController
 * @version:v1.0
 * @Description: Java代码生成器控制入口
 * @author: xuyushuai
 * @date: 2015年3月27日 下午2:08:57
 *
 */
@RestController
@RequestMapping("/gencode/java")
public class GenJavaCodeController {

	@RequestMapping(value="/genservice",method=RequestMethod.POST)
	public Map<String,String> genService(String xml, String prefix) {
		initGlobalConfig(prefix);
		// 获取XML的document

		String fullXml = "<service>" + xml + "</service>";
		InputStream inputStream = new ByteArrayInputStream(fullXml.getBytes());
		Document document = XMLParseUtil.getDocument(inputStream);

		String interfaceCode = GenServiceCode.genInterface(document);
		String implCode = GenServiceCode.genImpl(document);
		
//		if (GenErrorDetail.hasError()) {
//				return GenErrorDetail.errorProcess(model);
//		}
		Map<String,String> codeMap = new HashMap<String,String>();
		codeMap.put("interfaceCode", interfaceCode);
		codeMap.put("implCode", implCode);

		return codeMap;
	}

	@RequestMapping("/genmanager")
	public String genManager(String xmlTemp, String prefix, ModelMap model) {
		initGlobalConfig(prefix);
		// 获取XML的document
		if (xmlTemp != null) {
			String fullXml = "<manager>" + xmlTemp + "</manager>";

			InputStream inputStream = new ByteArrayInputStream(fullXml.getBytes());
			Document document = XMLParseUtil.getDocument(inputStream);

			String interfaceCode = GenManagerCode.genInterface(document);
			String implCode = GenManagerCode.genImpl(document);
			
			if (GenErrorDetail.hasError()) {
				return GenErrorDetail.errorProcess(model);
			}
			
			model.addAttribute("interfaceCode", StringEscapeUtils.escapeHtml(interfaceCode));
			model.addAttribute("implCode", StringEscapeUtils.escapeHtml(implCode));
			model.addAttribute("prefix", prefix);
		}

		// 将传入的xml返回
		setXml(xmlTemp, model);

		model.addAttribute("type", "Manager");
		return "content/gencode/java/javacode";
	}

	@RequestMapping("/gendao")
	public String genDao(String xmlTemp, String prefix, ModelMap model) {
		initGlobalConfig(prefix);

		if (xmlTemp != null) {
			// 获取XML的document
			String fullXml = "<dao>" + xmlTemp + "</dao>";
			InputStream inputStream = new ByteArrayInputStream(fullXml.getBytes());
			Document document = XMLParseUtil.getDocument(inputStream);

			String interfaceCode = GenDaoCode.genInterface(document);
			String implCode = GenDaoCode.genImpl(document);

			if (GenErrorDetail.hasError()) {
				return GenErrorDetail.errorProcess(model);
			}

			model.addAttribute("interfaceCode", StringEscapeUtils.escapeHtml(interfaceCode));
			model.addAttribute("implCode", StringEscapeUtils.escapeHtml(implCode));
			model.addAttribute("prefix", prefix);
		}
		// 将传入的xml返回
		setXml(xmlTemp, model);

		model.addAttribute("type", "Dao");
		return "content/gencode/java/javacode";
	}

	private void setXml(String xmlTemp, ModelMap model) {
		if (xmlTemp != null && !xmlTemp.equals("")) {
			String xml = "";
			for (String code : xmlTemp.split("</method>")) {
				xml = xml + code + "</method>" + "\n";
			}
			model.addAttribute("xml", xml);
		}
	}

	private void initGlobalConfig(String prefix) {
		if (GenGlobalConfig.getGlobalConfig() != null) {
			GenGlobalConfig.getGlobalConfig().setDaoPrefix(prefix);
			GenGlobalConfig.getGlobalConfig().setManagerPrefix(prefix);
			GenGlobalConfig.getGlobalConfig().setServicePrefix(prefix);
		} else {
			GlobalConfig globalConfig = new GlobalConfig();
			globalConfig.setServicePrefix(prefix);
			globalConfig.setManagerPrefix(prefix);
			globalConfig.setDaoPrefix(prefix);
			GenGlobalConfig.setGlobalConfig(globalConfig);
		}
	}

	
}