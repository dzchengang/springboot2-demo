package com.sdstc.service.transtional.impl;

import com.sdstc.Start;
import com.sdstc.service.redis.RedisDao;
import com.sdstc.service.transtional.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Start.class)
public class UserServiceImplTest {
    @Autowired
    private RedisDao redisDao;


}