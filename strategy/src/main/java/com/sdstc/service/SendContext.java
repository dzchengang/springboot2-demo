package com.sdstc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SendContext {
	Map<String,SendStrategy> sendStrategyMap = new HashMap<>();
	
	public SendContext(List<SendStrategy> sendStrategys) {
		for (SendStrategy sendStrategy : sendStrategys) {
			sendStrategyMap.put(sendStrategy.getType(), sendStrategy);
		}
	}
	
	public void send(String type, List<String> msgs) {
		sendStrategyMap.get(type).sendMsg(msgs);
	}
}
