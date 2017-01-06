package com.cheney.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Moudle: IndexController
 * @Description: 主页控制入口
 * @author: xuyushuai
 * @date: 2016年12月30日 11:26:02
 *
 */
@Controller
public class IndexController {
	@RequestMapping("/")
	public String indexPage(HttpServletRequest request, ModelMap model) {
		return "layout/layout_index";
	}
	@RequestMapping("/layout_config.html")
	public String configPage(HttpServletRequest request, ModelMap model) {
		return "layout/layout_index";
	}
	@RequestMapping("/layout_foreground.html")
	public String foreGroundPage(HttpServletRequest request, ModelMap model) {
		return "layout/layout_foreground";
	}
	@RequestMapping("/layout_background.html")
	public String backGroundPage(HttpServletRequest request, ModelMap model) {
		return "layout/layout_background";
	}
	@RequestMapping("/layout_development.html")
	public String developmentPage(HttpServletRequest request, ModelMap model) {
		return "layout/layout_development";
	}
}