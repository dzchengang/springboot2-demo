package com.sdstc.rabbitmq.topic;

import java.io.IOException;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

@Service
public class TopicReceiver {
	@RabbitListener(queues = "queue1")
	public void receiveTopic3(Message message, Map<String,Object> map,Channel channel) throws IOException, InterruptedException {
		System.out.println(map.get("a"));
		//Thread.sleep(1000L*3);
		System.out.println("timeout");
		// 手工确认
		long deliveryTag = message.getMessageProperties().getDeliveryTag();
		channel.basicAck(deliveryTag, true);
	}

}
