package com.sdstc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PubController {

	@GetMapping("/admin")
	public Map<String, String> admin() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("x", "y");
		return result;
	}
	
	@GetMapping("/user")
	public Map<String, String> user() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("x", "y");
		return result;
	}
	
	@GetMapping("/callback")
	public Map<String, String> callback() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("callback", "callback");
		return result;
	}
}
