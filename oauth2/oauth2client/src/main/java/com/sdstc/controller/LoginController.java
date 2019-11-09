package com.sdstc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {
	@GetMapping("/login/mobile")
	public Map<String, String> ajaxLogin() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("x", "y");
		return result;
	}
}
