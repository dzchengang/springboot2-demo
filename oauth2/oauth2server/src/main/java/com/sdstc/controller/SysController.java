package com.sdstc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SysController {
	@GetMapping("/error")
	public Map<String, String> error() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("error", "y");
		return result;
	}
}
