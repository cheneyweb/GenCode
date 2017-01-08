package com.cheney.web.controller.sql;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "SQLQuery")
@RestController
@RequestMapping("/gencode/sql")
public class GenQueryCodeController {

	@ApiOperation(value = "生成SQL查询代码", notes = "")
	@RequestMapping(value = "/genquery", method = RequestMethod.POST)
	public String genQuery() {
		return "建设中...";
	}
}
