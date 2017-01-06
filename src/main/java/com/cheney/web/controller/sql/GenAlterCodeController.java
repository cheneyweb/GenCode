package com.cheney.web.controller.sql;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gencode/sql")
public class GenAlterCodeController {
	@RequestMapping("/genalter")
	public String genAlter() {
		return "建设中...";
	}
}
