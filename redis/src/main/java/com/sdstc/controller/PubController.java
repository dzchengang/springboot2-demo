package com.sdstc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PubController {
	
	@GetMapping("/sendReq")
	public Map<String, String> sendReq() {
		Map<String, String> result = new HashMap<String, String>();
		
		return result;
	}
}
