package com.sdstc.alipay.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AliPayContentDto {
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	@JsonProperty("product_code")
	private String productCode;
	@JsonProperty("total_amount")
	private String totalAmount;
	@JsonProperty("subject")
	private String subject;
	@JsonProperty("body")
	private String body;
	@JsonProperty("passback_params")
	private String passbackParams;
	@JsonProperty("extend_params")
	private Map<String, String> extendParams;

	
	public AliPayContentDto() {
		
	}
	
	public AliPayContentDto(String outTradeNo,String productCode,String totalAmount,String subject) {
		this.outTradeNo=outTradeNo;
		this.productCode=productCode;
		this.totalAmount=totalAmount;
		this.subject=subject;
	}
	
}
