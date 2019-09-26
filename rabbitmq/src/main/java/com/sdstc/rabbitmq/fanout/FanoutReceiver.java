package com.sdstc.rabbitmq.fanout;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.sdstc.config.RabbitConfig;
import com.sdstc.dto.User;

@Service
public class FanoutReceiver {
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE1)
    public void receiveTopic1(User user,Channel channel,Message message) {
    	 System.out.println("【receiveFanout1监听到消息】" + user);
    	 
    	try {
			channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
		} catch (IOException e) {
			e.printStackTrace();
		}
       
    }
 
    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE2)
    public void receiveTopic2(User user) {
        System.out.println("【receiveFanout2监听到消息】" + user);
    }

}
