package com.sdstc.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class ClickhouseConfig {
    @Resource
    private JdbcParamConfig jdbcParamConfig;

    @Bean
    public DataSource dataSource() {
        HikariDataSource datasource = new HikariDataSource();
        datasource.setJdbcUrl(jdbcParamConfig.getUrl());
        datasource.setDriverClassName(jdbcParamConfig.getDriverClassName());
        return datasource;
    }
}
