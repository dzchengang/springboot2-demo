package com.sdstc.service.impl;

import com.sdstc.dao.UserDao;
import com.sdstc.model.User;
import com.sdstc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private UserDao userDao;
    @Autowired
    Test2Service test2Service;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void test(String id)  {
       //this.test();
        test2Service.test();
        int i=1/0;
    }

    /**
     * 在本地无法实现
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test()  {
        userDao.insertUser(new User("cheng"));
    }
}
