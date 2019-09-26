package com.sdstc.rabbitmq.redirect;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdstc.config.RabbitConfig;
import com.sdstc.dto.User;

@Service
public class DirectSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(User user) {
		this.rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE, "a", user);
		//this.rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE, "b", user);
	}
}
