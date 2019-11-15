package com.sdstc.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PubController {

	@GetMapping("/login")
	public Map<String, String> sendReq() {
		Subject subject = SecurityUtils.getSubject();
		/*
		 * UsernamePasswordToken token = new
		 * UsernamePasswordToken(user.getAccount(),AESUtil.decrypt(user.getPassword()),
		 * "password"); subject.login(token);
		 */
		
		Map<String, String> result=new HashMap<String,String>();
		return result;
	}
}
