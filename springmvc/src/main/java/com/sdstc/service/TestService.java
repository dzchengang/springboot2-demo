package com.sdstc.service;

import org.springframework.stereotype.Service;

import com.sdstc.controller.DataSourceContextHolder;

@Service("testService")
public class TestService {
	public String test(String code) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String dbCode = DataSourceContextHolder.getDbType();
		if (!code.equals(dbCode)) {
			System.out.println("--");
		}
		return null;
	}
}
