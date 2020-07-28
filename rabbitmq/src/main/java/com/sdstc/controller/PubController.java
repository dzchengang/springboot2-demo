package com.sdstc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sdstc.rabbitmq.topic.TopicSender;

@RestController
@RequestMapping("/")
public class PubController {
	@Autowired
	TopicSender topicSender;

	@GetMapping("/sendReq")
	public String sendReq() {
		topicSender.send();
		return "sucess";
	}
}
