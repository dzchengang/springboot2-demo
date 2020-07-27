package com.sdstc.mybatis.dydbconfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DyDSRouting extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		
		return null;
	}

}
