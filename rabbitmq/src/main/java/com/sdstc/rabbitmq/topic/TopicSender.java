package com.sdstc.rabbitmq.topic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicSender {
	@Autowired
	RabbitTemplate rabbitTemplate;

	public void send() {
		Map<String, Object> params = new HashMap<>();
		params.put("a", "A");
		rabbitTemplate.convertAndSend("queue1", params);
	}

}
