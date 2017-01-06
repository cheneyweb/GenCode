package com.cheney.web.controller.sql;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gencode/sql")
public class GenQueryCodeController {
	@RequestMapping("/genquery")
	public String genQuery() {
		return "建设中...";
	}
}
