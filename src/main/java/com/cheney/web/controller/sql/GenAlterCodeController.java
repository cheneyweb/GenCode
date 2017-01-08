package com.cheney.web.controller.sql;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "SQLAlter")
@RestController
@RequestMapping("/gencode/sql")
public class GenAlterCodeController {

	@ApiOperation(value = "生成SQL更新代码", notes = "")
	@RequestMapping(value = "/genalter", method = RequestMethod.POST)
	public String genAlter() {
		return "建设中...";
	}
}
