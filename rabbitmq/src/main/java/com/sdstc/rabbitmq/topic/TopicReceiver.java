package com.sdstc.rabbitmq.topic;

import java.io.IOException;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

import static com.sdstc.config.RabbitConfig.TOPIC_QUEUE1;
import static com.sdstc.config.RabbitConfig.TOPIC_QUEUE2;

@Service
public class TopicReceiver {
	@RabbitListener(queues = TOPIC_QUEUE1)
	public void receiveTopic1(Message message, Map<String,Object> map,Channel channel) throws IOException, InterruptedException {
		long deliveryTag = message.getMessageProperties().getDeliveryTag();
		System.out.println("queue1"+map.get("a"));
		Thread.sleep(1000*10);
		//第二个参数，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
		channel.basicAck(deliveryTag,true);
	}

	@RabbitListener(queues = TOPIC_QUEUE2)
	public void receiveTopic2(Message message, Map<String,Object> map,Channel channel) throws IOException, InterruptedException {
		long deliveryTag = message.getMessageProperties().getDeliveryTag();
		System.out.println("queue2"+map.get("a"));
		//第二个参数，true会重新放回队列，false会丢弃这条数据
		channel.basicReject(deliveryTag, false);
	}
}
