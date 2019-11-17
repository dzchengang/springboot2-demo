package com.sdstc.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.model.User;

@RestController
@RequestMapping("/")
public class PubController {

	@GetMapping("/login")
	public Map<String, String> login(User user) {
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(),user.getPassword()); 
		subject.login(token);
		
		Map<String, String> result=new HashMap<String,String>();
		return result;
	}
	
	
	@GetMapping("/test")
	public Map<String, String> test() {
		Map<String, String> result=new HashMap<String,String>();
		result.put("result", "success");
		return result;
	}
}
