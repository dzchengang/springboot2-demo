package com.sdstc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.service.TestService;

@RestController
@RequestMapping("/")
public class PubController {
	@Autowired
	private TestService testService;

	@PostMapping("/test")
	public String test(String code) {
		DataSourceContextHolder.setDbType(code);
		testService.test(code);
		return "result:" + code;
	}
}
