package com.sdstc.rabbitmq.topic;

import java.io.IOException;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.sdstc.config.RabbitConfig;
import com.sdstc.project.dto.ProjectProInfoDto;

@Service
public class TopicReceiver {
	// queues是指要监听的队列的名字
	@RabbitListener(queues = RabbitConfig.TOPIC_QUEUE1)
	public void receiveTopic1(Message message, ProjectProInfoDto user, Channel channel) throws IOException {
		System.out.println("【receiveTopic1监听到消息】" + user.toString());

		// 手工确认
		long deliveryTag = message.getMessageProperties().getDeliveryTag();
		channel.basicAck(deliveryTag, true);
	}

	@RabbitListener(queues = RabbitConfig.TOPIC_QUEUE2)
	public void receiveTopic2(Message message, ProjectProInfoDto user, Channel channel) throws IOException {
		System.out.println("【receiveTopic2监听到消息】" + user.toString());

		// 手工确认
		long deliveryTag = message.getMessageProperties().getDeliveryTag();
		channel.basicAck(deliveryTag, true);
	}
	
	@RabbitListener(queues = RabbitConfig.TOPIC_QUEUE3)
	public void receiveTopic3(Message message, Map<String,Object> map , Channel channel) throws IOException {
		
System.out.println(map);
		// 手工确认
		long deliveryTag = message.getMessageProperties().getDeliveryTag();
		channel.basicAck(deliveryTag, true);
	}

}
