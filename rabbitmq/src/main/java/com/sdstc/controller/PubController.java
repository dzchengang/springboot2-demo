package com.sdstc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.project.dto.ProjectProInfoDto;
import com.sdstc.rabbitmq.topic.TopicSender;

@RestController
@RequestMapping("/")
public class PubController {
	@Autowired
	TopicSender topicSender;
	
	@GetMapping("/sendReq")
	public Map<String, String> sendReq() {
		Map<String, String> result = new HashMap<String, String>();
		
		ProjectProInfoDto user = new ProjectProInfoDto();
		user.setCustomerId(1L);
		
		topicSender.send(user);
		
		return result;
	}
}
