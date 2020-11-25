package com.sdstc.service.transtional.impl;

import com.sdstc.dao.UserDao;
import com.sdstc.model.User;
import com.sdstc.service.redis.RedissonLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("test2Service")
public class Test2Service {
    @Autowired
    private UserDao userDao;
    @Autowired
    RedissonLock redissonLock;

    /**
     * 重新开启新事务
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test()  {
        userDao.insertUser(new User("cheng"));
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void test1()  {
        userDao.insertUser(new User("cheng"));
    }

}
