package com.sdstc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sdstc.service.SendStrategy;

@Service
public class EmailSend implements SendStrategy {

	@Override
	public void sendMsg(List<String> msgs) {
		System.out.println("-----email--------");
		msgs.add("append email");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(String msg:msgs) {
			System.out.println(msg);
		}
	}

	@Override
	public String getType() {
		return "email";
	}

}
