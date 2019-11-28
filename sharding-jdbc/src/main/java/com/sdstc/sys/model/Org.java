package com.sdstc.sys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Org {
	private Integer id;
	private String name;
	private String systemId;
	private String tenantId;
}
