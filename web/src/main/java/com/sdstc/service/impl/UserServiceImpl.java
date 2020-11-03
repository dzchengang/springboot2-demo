package com.sdstc.service.impl;

import com.sdstc.dao.UserDao;
import com.sdstc.model.Org;
import com.sdstc.model.User;
import com.sdstc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    /**
     *事务传播方式
     * Propagation.MANDATORY: 必须在一个已有的事务中执行,否则抛出异常,要求调用此方法的必须有事务
     * Propagation.REQUIRED: 如果当前存在事务，则加入该事务，如果当前不存在事务，则创建一个新的事务。
     * Propagation.SUPPORTS: 如果当前存在事务，则加入该事务；如果当前不存在事务，则以非事务的方式继续运行。
     * Propagation.REQUIRES_NEW: 重新创建一个新的事务，如果当前存在事务，暂停当前的事务。
     * Propagation.NOT_SUPPORTED: 以非事务的方式运行，如果当前存在事务，暂停当前的事务.
     * Propagation.NEVER:  以非事务的方式运行，如果当前存在事务，则抛出异常。
     *
     * 事务的隔离级别
     *
     *
     * readOnly: 用于查询
     *
     *
     * 事务失效的情况
     * 1：注释在非 public 修饰的方法上
     * 2：同一个类中方法调用，导致@Transactional失效，如果A方法调用B方法，A没有使用事务则即使B配置了事务也不会起作用。
     * 3：异常
     */
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void insertUser() {
        User user = new User("1", "a");
        userDao.insertUser(user);
        Org org = new Org("1", "a");
        userDao.insertOrg(org);
    }

    @Override
    public void insertOrg() {
        User user = new User("2", "b");
        userDao.insertUser(user);
        Org org = new Org("2", "b");
        userDao.insertOrg(org);

    }

    @Override
  //  @Transactional(propagation = Propagation.REQUIRED)
    public void insert() {
        this.insertUser();
        //int a=1/0;
        //this.insertOrg();
    }

}
