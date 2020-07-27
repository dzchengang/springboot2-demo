package com.sdstc.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	public static final String TOPIC_EXCHANGE = "order.topic";
	public static final String TOPIC_QUEUE3 = "order.topic.addhostchengang.lre";
	
	public static final String TOPIC_QUEUE_ORDER_PAY_LRE = "order.topic.paykamy.lre";// 交付lre产品
	  public static final String TOPIC_QUEUE_ADDHOST_LRE = "order.topic.addhostkamy.lre";// 交付lre产品
	
	/*
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
		}*/
}
