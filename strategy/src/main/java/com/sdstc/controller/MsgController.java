package com.sdstc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdstc.service.SendContext;

@RestController
@RequestMapping("/")
public class MsgController {
	@Autowired
	private SendContext sendContext;

	@GetMapping("/sendReq")
	public String sendReq() {
		List<String> a = new ArrayList<>();
		a.add("b");
		sendContext.send("email", a);
		return null;
	}
}
