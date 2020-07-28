package com.sdstc.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	@Autowired
	AmqpAdmin amqpAdmin;
	
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
    public void createExchangeQueue (){
		amqpAdmin.declareExchange(topicExchange());
		amqpAdmin.declareQueue(topicQueue());
    }

}
