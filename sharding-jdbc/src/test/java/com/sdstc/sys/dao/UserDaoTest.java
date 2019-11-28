package com.sdstc.sys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.sys.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
	@Autowired
	private UserDao userDao;

	@Test
	public void testInsert() {
		User dto=new User();
		dto.setId(1);
		dto.setName("user2");
		dto.setSystemId("1");
		dto.setTenantId("2");
		userDao.insert(dto);
	}

}
