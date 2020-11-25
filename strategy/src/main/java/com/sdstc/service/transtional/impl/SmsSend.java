package com.sdstc.service.transtional.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sdstc.service.SendStrategy;

@Service
public class SmsSend implements SendStrategy {
	@Override
	public void sendMsg(List<String> msgs) {
		System.out.println("sms:");
		for(String msg:msgs) {
			System.out.println(msg);
		}
	}

	@Override
	public String getType() {
		return "sms";
	}

}
