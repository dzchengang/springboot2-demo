package com.sdstc.mybatis.dto;

import lombok.Data;

@Data
public class DBConfigDto {
	private Integer id;
	private String dbConnect;
	private String dbUser;
	private String dbPwd;
	private String driverClassName;
	
}
