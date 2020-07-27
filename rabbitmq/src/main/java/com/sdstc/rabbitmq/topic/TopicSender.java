package com.sdstc.rabbitmq.topic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdstc.config.RabbitConfig;
import com.sdstc.project.dto.ProjectProInfoDto;

@Service
public class TopicSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Autowired
	AmqpAdmin amqpAdmin;

	// 第一个参数：TopicExchange名字
	// 第二个参数：Route-Key
	// 第三个参数：要发送的内容
	public void send(ProjectProInfoDto user) {
		/*this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, RabbitConfig.TOPIC_QUEUE1, user);
		this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, RabbitConfig.TOPIC_QUEUE2, user);*/
		
		
		TopicExchange topicExchange=new TopicExchange(RabbitConfig.TOPIC_EXCHANGE);
		
		Queue queue2 = new Queue(RabbitConfig.TOPIC_QUEUE_ADDHOST_LRE);
		Binding  binding2=BindingBuilder.bind(queue2).to(topicExchange).with(RabbitConfig.TOPIC_QUEUE_ADDHOST_LRE);
		
		Queue queue3 = new Queue(RabbitConfig.TOPIC_QUEUE_ORDER_PAY_LRE);
		Binding  binding3=BindingBuilder.bind(queue3).to(topicExchange).with(RabbitConfig.TOPIC_QUEUE_ORDER_PAY_LRE);
		
		
		amqpAdmin.declareExchange(topicExchange);
		
		amqpAdmin.declareQueue(queue2);
		amqpAdmin.declareBinding(binding2);
		
		amqpAdmin.declareQueue(queue3);
		amqpAdmin.declareBinding(binding3);
		
		
		Map<String,Object> params=new HashMap<>();
		params.put("a", 1);
		this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, RabbitConfig.TOPIC_QUEUE3, user);
	}

}
