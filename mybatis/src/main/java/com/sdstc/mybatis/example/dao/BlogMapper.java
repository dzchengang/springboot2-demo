package com.sdstc.mybatis.example.dao;

import java.util.List;

import com.sdstc.mybatis.example.dto.TaskDto;

public interface BlogMapper {
	public List<TaskDto> selectTask(TaskDto dto);
}
