package com.sdstc.rabbitmq.redirect;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.sdstc.config.RabbitConfig;
import com.sdstc.dto.User;

@Service
public class DirectReceiver {
	@RabbitListener(queues = RabbitConfig.DIRECT_QUEUE1)
	public void receiveDirect1(User user) {
		System.out.println("【receiveDirect1监听到消息】" + user);
	}

	@RabbitListener(queues = RabbitConfig.DIRECT_QUEUE2)
	public void receiveDirect2(User user) {
		System.out.println("【receiveDirect2监听到消息】" + user);
	}
}
