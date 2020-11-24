package com.sdstc.controller;

import com.sdstc.advice.SecretAnnotation;
import com.sdstc.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.service.TestService;

@Controller
@RequestMapping("/")
public class PubController {
	@Autowired
	private TestService testService;

	@RequestMapping("/test")
	@SecretAnnotation(decode = true,encode = true)
	public User test(@RequestBody User user) {

		user.setName("xxx");
		return user;
	}
	@RequestMapping("/test1")
	public String redict(){
		return "redirect:https://resource.yuntest.top/MF_VuGen_2020_SP3_Windows.exe";
	}
}
