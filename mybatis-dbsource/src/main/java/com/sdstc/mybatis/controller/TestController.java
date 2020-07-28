package com.sdstc.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.mybatis.dao.TestDao;
import com.sdstc.mybatis.dto.UserDto;
import com.sdstc.mybatis.dydbconfig.DSContextHolder;

@RestController
@RequestMapping("/")
public class TestController {
	@Autowired
	private TestDao testDao;

	@PostMapping("/test")
	public String test(String code) {
		DSContextHolder.setDbKey(code);
		List<UserDto> users = testDao.getUsers();

		StringBuffer sb = new StringBuffer();
		if (users != null) {
			for (UserDto user : users) {
				sb.append(user.getName() + ",");
			}
		}

		System.out.println(code + ":" + sb.toString());
		return "result:" + code;
	}
}
