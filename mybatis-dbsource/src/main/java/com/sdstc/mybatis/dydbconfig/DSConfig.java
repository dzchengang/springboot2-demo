package com.sdstc.mybatis.dydbconfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DSConfig {

	@Bean("dyDS")
	public DataSource dyDS(DataSource dataSource) {
		// 动态数据源
		DyDSRouting dyDSRouting = new DyDSRouting();
		// 指定默认数据源
		dyDSRouting.setDefaultTargetDataSource(dataSource);
        // 设置 数据源
		return dyDSRouting;
	}
}
