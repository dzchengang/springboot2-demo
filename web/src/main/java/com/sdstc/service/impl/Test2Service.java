package com.sdstc.service.impl;

import com.sdstc.dao.UserDao;
import com.sdstc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service("test2Service")
public class Test2Service {
    @Autowired
    private UserDao userDao;
    @Autowired
    RedissonLock redissonLock;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test()  {
        userDao.insertUser(new User("cheng"));
    }

}
