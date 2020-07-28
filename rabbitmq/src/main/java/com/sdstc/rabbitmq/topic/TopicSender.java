package com.sdstc.rabbitmq.topic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdstc.config.RabbitConfig;

@Service
public class TopicSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Autowired
	AmqpAdmin amqpAdmin;

	public void send() {
		Map<String,Object> params=new HashMap<>();
		params.put("a", 1);
		this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, RabbitConfig.TOPIC_QUEUE, params);
	}

}
