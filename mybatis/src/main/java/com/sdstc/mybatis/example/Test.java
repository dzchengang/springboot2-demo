package com.sdstc.mybatis.example;

import java.io.InputStream;
import java.util.List;

import com.sdstc.mybatis.example.dao.BlogMapper;
import com.sdstc.mybatis.example.dto.TaskDto;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
		
		TaskDto dto=new TaskDto();
		dto.setTaskName("备案材料");
		List<TaskDto> results = mapper.selectTask(dto);
		results.forEach(item ->{
			System.out.println(item.getId()+":"+item.getTaskName());
		});
	}
}
