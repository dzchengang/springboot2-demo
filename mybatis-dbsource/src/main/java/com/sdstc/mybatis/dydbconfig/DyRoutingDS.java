package com.sdstc.mybatis.dydbconfig;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.sdstc.mybatis.dao.TestDao;
import com.sdstc.mybatis.dto.DBConfigDto;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DyRoutingDS extends AbstractRoutingDataSource {

	private DataSource master;
	private TestDao testDao;

	Map<String, DataSource> dataSources = new HashMap<String, DataSource>();

	@Override
	protected Object determineCurrentLookupKey() {
		return DSContextHolder.getDbKey();
	}

	@Override
	protected DataSource determineTargetDataSource() {
		String dbKey = (String) determineCurrentLookupKey();
		if (dataSources.containsKey(dbKey)) {
			return dataSources.get(dbKey);
		} else {
			return this.selectDataSource(dbKey);
		}
	}

	/**
	 * 从数据库中查询
	 * 
	 * @param dbKey
	 * @return
	 */
	private synchronized DataSource selectDataSource(String dbKey) {
		// 再次从数据库中获取，双检锁
		DataSource ds = (DataSource) this.dataSources.get(dbKey);
		if (null != ds) {
			return ds;
		} else {
			if (this.testDao == null) {
				this.setTestDao();
			}

			DSContextHolder.setDbKey("master");
			DBConfigDto config = testDao.getDBConfigs(dbKey);
			if (config != null) {
				ds = this.parseT2Db(config);
				this.dataSources.put(dbKey, ds);
			} else {
                
			}
			DSContextHolder.setDbKey(dbKey);
			return ds;
		}
	}

	/**
	 * tenantDto 转数据源
	 * 
	 * @param tDto
	 * @return
	 */
	private DataSource parseT2Db(DBConfigDto tDto) {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(tDto.getDriverClassName());
		config.setJdbcUrl(tDto.getDbConnect());
		config.setUsername(tDto.getDbUser());
		config.setPassword(tDto.getDbPwd());
		return new HikariDataSource(config);
	}

	@Override
	public void afterPropertiesSet() {

	}

	public void setTestDao() {
		this.testDao = SpringContextUtil.getBean("testDao", TestDao.class);
	}

	public void setMasterDS(DataSource master) {
		this.master = master;
		this.dataSources.put("master", this.master);
	}
}
