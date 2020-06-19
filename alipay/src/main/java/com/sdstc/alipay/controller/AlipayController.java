package com.sdstc.alipay.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdstc.alipay.dto.AliPayContentDto;

@RestController
@RequestMapping("/")
public class AlipayController {
	private static final String APP_ID="2021001167603044";
	private static final String APP_PRIVATE_KEY="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCMTOhT8ozusd2xALkbX/Nw+q2JsiowaFHYAv8ahLvCAMQg5G6jcbUICXRScOVhYQlzZ5HVXqyBahzmNA4xxstMfq9vCJwEOvjZL/BDObvOVZDmfzM84wOsx12gscjE6Id+vHFJ8Dy7097SPgN6ZPiXJcsnzGq/VGSbjUjPMq7+aphuMM0RCyCVpjtVBmzc1SOlfdSpVh7o3oXdVi7nnZPPrSemLnS+Jzvlk/SqZKtlNS3kM7W4rpUNMA3SDIoAObreAuX3B6DaEpL80zk1PKYzrYWoHzFeMkmjuR+cPPtfEdkr3Cq6vsGMp8KITnD3l8stbB7V3jAa1iD5DGUoSyuxAgMBAAECggEAbVRpHzG9vSwBs7L6jGiDDiFqJgkec0Z3sLr1DDcvEQkDzRX1WYx8I90qNiwfs3ioorOsovb5uod0Kbea8BMXzW5TS1UMLwe9b5G5ysksnqdzGQs6ZFILRRK+1UB1UWxaWdqC9bkturhpxK/qifAw/6fF3iefb6VWGRlKCZxXXY2ImMpTm0qFcDFzOSp9/ddRMXDkVN/c3rjA516F78tot7+g4Ntr9aa/K0w/ASFGXxuXzhOvgx+q7dKMq1Jc6x189gqpFYu2FFeUWZ3NqNrATOz6V15boKsPGVI5tg7+GzVQYoziTrb4cOy+J5P95x2cguLCzoNZdwNApyJx8cSFuQKBgQDtFXtAd9+pV7aVhQgl8G+Ijc4msmm+4c+5Q3Sjepd7HDy1kcWP1j9oJ3nxazHaOtZpXotM4KGQ7GWYr6cpq57J947d+EORiTP9LshVgQ2CFE/cq+p0xrpnzD6OoQSf69kbYs32EF7/U3xXt529byTBHKveFFb6clyJLV3ZOgAhFwKBgQCXfpc68WIUsCllslRR2Xjo4FCzFCWFf/JWvcFGsyUnHJrCiqYBV7xprEyhM3eiX/JHE0KK/yJZm5CwPC0h3U9wXb9/SXtJdAfL3btKfdWHHZCc9oIO2vx9dHXzDxZKNx839MzbAogQs/7b1J6WgPZ5k3n/AK1/NorHO/D9avzGdwKBgQCLoHwfIropnIvekSOUXH8DWCiSJ78ZeRoCTRTzdq6iBaZHdNt6c76SE7XAldYdZUuDcPfvRdhBZsgK3WBArV9uKQsN9TmuC7T/pj68BK407st99g21yphbqzEohPIZUShi9ZTBFzErhDqV2oDe4QcvaDhcKXR0OUgATiSYW41Z7wKBgFso5b+mOKrSRlbXtD18a3FWabkYymtGzoC7tm3gpt6eK9IctD/il5HPCF2IJtkiexuhz0zssbLSFYK280GJdp/bCbyCbxmIJJjcWDM+/RpNBBQvkZt20rB7P+5+iZ8nBDYbrJmtMEs8xINrsfJGsAoAYEy+D6iZHXE99InJs0mJAoGBAKkabekGXA+GbVPgSMjAJ8JfGCbQLQN/WRJ2MVofBhq9xQUsCGd5tkC61nnb9qComHOatbkaplgFx/RGPJFaiiC2qhHCN9yOIPLGYWGoxB3s8DSl9VwGOQrAxFQEfD1F/uWN0dzsCKSHyyXvQycz/6l1HchXYEnuVgmZI+V2UVol";
	private static final String FORMAT="json";
	private static final String CHARSET="UTF-8";
	private static final String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoNPrjbWuJUT+OeOar9YDeY2TUstLvvgcjhiqZ7VsPduKoBfSrIUPqPkTz7CdJlIpHlxlHQfm6JQ1Ljcb+t84TWxsm6/V6BHZsnrps72as7BgH9h8b5IfjwUtHrvgu3LZuxleWP/u34HMlpGhBFOgPBcYDfZQg/Fmg04PAo3J8N6P9caAU++DUFgJAfWa0PSKJUn8P8nPIyGHxFPPUTPZMpXEGqIeAm+XunlLEf/+nj3vVgYfUKJL3L1UK58St7tkPlWL3mXmCtV2t4Av5eBGilbYSCD3vlZznkYY/nxygEudvfJIkZCF8sMLWHR8uKKgt1ginwYatonPVdte/4J7IwIDAQAB";
	private static final String SIGN_TYPE="RSA2";
	
	@GetMapping("/pay") 
	public void pay(HttpServletRequest httpRequest,HttpServletResponse httpResponse) throws IOException, AlipayApiException {
		//获得初始化的AlipayClient 
		AlipayClient alipayClient =  new  DefaultAlipayClient( "https://openapi.alipay.com/gateway.do" , APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
		
		//创建API对应的request 
		AlipayTradePagePayRequest alipayRequest =  new  AlipayTradePagePayRequest();
		
		//在公共参数中设置回跳和通知地址
	    alipayRequest.setReturnUrl( "http://58.56.56.251:8089/callback" );
	    alipayRequest.setNotifyUrl( "http://58.56.56.251:8089/notify" ); 
	    
	    //填充业务参数 
	    AliPayContentDto contentDto=new AliPayContentDto("20150320010101005", "FAST_INSTANT_TRADE_PAY","0.01", "test");
	    ObjectMapper om = new ObjectMapper();
	    om.setSerializationInclusion(Include.NON_NULL);
	    alipayRequest.setBizContent(om.writeValueAsString(contentDto));
	    //调用SDK生成表单 
	    String form= alipayClient.pageExecute(alipayRequest).getBody();
	    
	    httpResponse.setContentType("text/html;charset=" + CHARSET);
	    httpResponse.getWriter().write(form); //直接将完整的表单html输出到页面 
	    httpResponse.getWriter().flush();
	    httpResponse.getWriter().close();
	}
	
	/**
	 * 支付宝异步接口
	 * @param paramsMap
	 * @return
	 * @throws AlipayApiException
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/notify")
	public String notify(HttpServletRequest httpRequest) throws AlipayApiException, UnsupportedEncodingException {
		Boolean  signVerified = AlipaySignature.rsaCheckV1(this.getParam(httpRequest), ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE);
		System.out.println(signVerified);
		if (signVerified){
			
		} else {
		
		}
		return "test";
	}
	
	
	@RequestMapping("/callback")
	public String callback(HttpServletRequest httpRequest,Map<String, String> paramsMap) throws AlipayApiException, UnsupportedEncodingException {
		Map<String,String> params = this.getParam(httpRequest);
		return "test";
	}
	
	private  Map<String,String>  getParam(HttpServletRequest request) throws UnsupportedEncodingException {
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		return params;
	}
	
}
