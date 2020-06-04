package com.sdstc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.ProStart;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ProStart.class })
public class RedisDaoTest {
	@Autowired
    private RedisDao redisDao;
	@Test
	public void testSet() {
		redisDao.setKey("test", "test", 50000);
		
	}
	@Test
	public void testGet() {
		System.out.println(redisDao.getValue("a"));
	}

}
