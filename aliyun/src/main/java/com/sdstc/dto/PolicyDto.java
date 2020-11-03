package com.sdstc.dto;

import lombok.Data;

@Data
public class PolicyDto {
	private String accessid;
	private String policy;
	private String signature;
	private String dir;
	private String host;
	private String expire;
	private String callback;
	private String key;
}
