package com.sdstc.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdstc.config.RabbitConfig;
import com.sdstc.dto.User;

@Service
public class FanoutSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(User user) {
		this.rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE, "", user);
	}

}
