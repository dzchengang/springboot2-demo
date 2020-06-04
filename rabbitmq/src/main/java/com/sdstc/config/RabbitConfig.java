package com.sdstc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	public static final String TOPIC_EXCHANGE = "project.topic";
	public static final String TOPIC_QUEUE1 = "topic.queue.addProject.lre";
	public static final String TOPIC_QUEUE2 = "topic.queue.editProject.lre";

	@Bean
	public Queue topicQueue1() {
		return new Queue(TOPIC_QUEUE1);
	}

	@Bean
	public Queue topicQueue2() {
		return new Queue(TOPIC_QUEUE2);
	}

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(TOPIC_EXCHANGE);
	}

	@Bean
	public Binding topicBinding1() {
		return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(TOPIC_QUEUE1);
	}

	@Bean
	public Binding topicBinding2() {
		return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(TOPIC_QUEUE2);
	}
}
