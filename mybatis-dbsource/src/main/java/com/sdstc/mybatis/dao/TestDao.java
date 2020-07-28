package com.sdstc.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sdstc.mybatis.dto.DBConfigDto;
import com.sdstc.mybatis.dto.UserDto;

public interface TestDao {
	DBConfigDto  getDBConfigs(@Param("dbKey") String dbKey);
	List<UserDto> getUsers();
}
