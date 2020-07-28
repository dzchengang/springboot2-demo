package com.sdstc.mybatis.dydbconfig;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "dbs.master")
@MapperScan(basePackages = {"com.sdstc.mybatis.dao"}, sqlSessionTemplateRef = "sqlSessionTemplate")
@Data
public class DSConfig {
	private String url;
	private String username;
	private String password;
	private String driverClassName;
	private String type;

	/**
	 * 主数据源
	 * @return
	 */
	@Bean
	@Qualifier("dataSource")
	@Primary
	public DataSource dataSource() {
		HikariDataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
		dataSource.setJdbcUrl(this.getUrl());
		dataSource.setUsername(this.getUsername());
		dataSource.setPassword(this.getPassword());
		dataSource.setDriverClassName(driverClassName);
		return dataSource;
	}

	/**
	 * 动态数据源
	 * @param dataSource
	 * @return
	 */
	@Bean
	@Qualifier("dyRoutingDS")
	public DyRoutingDS dyRoutingDS(@Qualifier("dataSource") DataSource dataSource) {
		DyRoutingDS dyRoutingDS = new DyRoutingDS();
		dyRoutingDS.setDefaultTargetDataSource(dataSource);
		dyRoutingDS.setMasterDS(dataSource);
		return dyRoutingDS;
	}

	/**
	 * SqlSessionFactoryBean
	 * @param dyRoutingDS
	 * @return
	 * @throws IOException
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("dyRoutingDS") DataSource dyRoutingDS) throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setTypeAliasesPackage("com.sdstc.mybatis.dto");
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mappers/**Dao.xml"));
		sqlSessionFactoryBean.setDataSource(dyRoutingDS);
		org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration();
        configuration.setCallSettersOnNulls(true);
        sqlSessionFactoryBean.setConfiguration(configuration);
		return sqlSessionFactoryBean;
	}

	/**
	 * 事务
	 * @param dyRoutingDS
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager(@Qualifier("dyRoutingDS") DataSource dyRoutingDS) {
		return new DataSourceTransactionManager(dyRoutingDS);
	}
	
}
