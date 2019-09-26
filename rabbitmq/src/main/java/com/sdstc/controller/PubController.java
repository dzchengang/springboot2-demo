package com.sdstc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.dto.User;
import com.sdstc.rabbitmq.fanout.FanoutSender;

@RestController
@RequestMapping("/")
public class PubController {
	@Autowired
	private FanoutSender fanoutSender;

	@GetMapping("/sendReq")
	public Map<String, String> sendReq() {
		Map<String, String> result = new HashMap<String, String>();
		
		User user = new User();
		user.setId("1");
		user.setName("陈刚");
		fanoutSender.send(user);
		
		
		return result;
	}
}
