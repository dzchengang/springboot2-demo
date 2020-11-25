package com.sdstc.service.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.sdstc.config.RabbitConfig.TOPIC_EXCHANGE;

@Service
public class TopicSender {
	@Autowired
	RabbitTemplate rabbitTemplate;

	public void send() {
		Map<String, Object> params = new HashMap<>();
		params.put("a", "A");

		rabbitTemplate.convertAndSend(TOPIC_EXCHANGE,"a.sdstc", params);

		//rabbitTemplate.convertAndSend(TOPIC_EXCHANGE,"a.b.sdstcE", params);
	}

	public void send2() {
		Map<String, Object> params = new HashMap<>();
		params.put("a", "B");

		rabbitTemplate.convertAndSend(TOPIC_EXCHANGE,"a.sdstc", params);
		rabbitTemplate.convertAndSend(TOPIC_EXCHANGE,"a.b.sdstc", params);
	}
}
