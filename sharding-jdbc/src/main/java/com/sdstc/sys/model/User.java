package com.sdstc.sys.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private Integer id;
	private String name;
	private Integer tenantId;
}
