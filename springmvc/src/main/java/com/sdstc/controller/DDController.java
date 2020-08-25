package com.sdstc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiSnsGetuserinfoBycodeRequest;
import com.dingtalk.api.response.OapiSnsGetuserinfoBycodeResponse;
import com.taobao.api.ApiException;

@Controller
@RequestMapping("/")
public class DDController {
     String appId="dingoazhnfai3r9ykg07ao";
     String appSecret="WfMTZxEsvWm7Y-dg3P4bxFMQ1qGOmo_Ml4Qu4V0Da8edva-DF-g404nO-jzlIS5H";
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	

	@RequestMapping("/code")
	public String code(String code) throws ApiException {
		System.out.println(code);
		
		DefaultDingTalkClient  client = new DefaultDingTalkClient("https://oapi.dingtalk.com/sns/getuserinfo_bycode");
		OapiSnsGetuserinfoBycodeRequest req = new OapiSnsGetuserinfoBycodeRequest();
		req.setTmpAuthCode(code);
		OapiSnsGetuserinfoBycodeResponse response = client.execute(req,appId,appSecret);
		
		System.out.println(response.getBody());
		return "code";
	}
	
}
