package com.sdstc.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class RabbitConfig {
	@Autowired
	AmqpAdmin amqpAdmin;

	@Autowired
	RabbitTemplate rabbitTemplate;

	public static final String TOPIC_EXCHANGE = "exchange1";
	public static final String TOPIC_QUEUE = "queue1";

	@Bean
	public Queue topicQueue() {
		return new Queue(TOPIC_QUEUE);
	}

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(TOPIC_EXCHANGE);
	}

	@Bean
	public Binding topicBinding1() {
		return BindingBuilder.bind(topicQueue()).to(topicExchange()).with(TOPIC_QUEUE);
	}

	@Bean
	public void createExchangeQueue() {
		amqpAdmin.declareExchange(topicExchange());
		amqpAdmin.declareQueue(topicQueue());
	}

	
	public class SendConfirmCallback implements RabbitTemplate.ConfirmCallback {
		@Override
		public void confirm(CorrelationData correlationData, boolean ack, String cause) {
			if (ack) {
				System.out.println("Success... 消息成功发送到交换机! correlationData:" + correlationData);
			} else {
				System.out.println("Fail... 消息发送到交换机失败! correlationData:" + correlationData);
			}
		}
	}

	public class SendReturnCallback implements RabbitTemplate.ReturnCallback {
		@Override
		public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
			System.out.println("Fail... message:{},从交换机exchange:{},以路由键routingKey:{}," + "未找到匹配队列，replyCode:{},replyText:{}");
		}
	}

	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMandatory(true);
		rabbitTemplate.setConfirmCallback(new SendConfirmCallback());
		rabbitTemplate.setReturnCallback(new SendReturnCallback());
		return rabbitTemplate;
	}

}
