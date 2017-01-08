package com.cheney.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Moudle: IndexController
 * @Description: 主页控制入口
 * @author: xuyushuai
 * @date: 2016年12月30日 11:26:02
 *
 */
@Api(tags="WebIndex")
@Controller
public class IndexController {
	@ApiOperation(value = "首页", notes = "")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage() {
		return "layout/layout_index";
	}

	@ApiOperation(value = "系统设置", notes = "")
	@RequestMapping(value = "/layout_config.html", method = RequestMethod.GET)
	public String configPage() {
		return "layout/layout_index";
	}

	@ApiOperation(value = "前端代码", notes = "")
	@RequestMapping(value = "/layout_foreground.html", method = RequestMethod.GET)
	public String foreGroundPage() {
		return "layout/layout_foreground";
	}

	@ApiOperation(value = "后端代码", notes = "")
	@RequestMapping(value = "/layout_background.html", method = RequestMethod.GET)
	public String backGroundPage() {
		return "layout/layout_background";
	}

	@ApiOperation(value = "运维代码", notes = "")
	@RequestMapping(value = "/layout_development.html", method = RequestMethod.GET)
	public String developmentPage() {
		return "layout/layout_development";
	}
}