package com.sdstc.redisson.lock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.redisson.Start;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Start.class })
public class RedisDaoTest {
	@Autowired
	private RedisDao redisDao;

	@Test
	public void test() {
		redisDao.setKey("a", "b", 5000);
	}

}
