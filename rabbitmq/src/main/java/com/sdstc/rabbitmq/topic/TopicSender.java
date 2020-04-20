package com.sdstc.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdstc.config.RabbitConfig;
import com.sdstc.dto.User;

@Service
public class TopicSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	// 第一个参数：TopicExchange名字
	// 第二个参数：Route-Key
	// 第三个参数：要发送的内容
	public void send(User user) {
		this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, "project.lre.add", user);
		this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, "project.lre.del", user);
	}

}
