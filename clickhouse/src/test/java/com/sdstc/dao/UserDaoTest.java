package com.sdstc.dao;

import com.sdstc.Start;
import com.sdstc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Start.class)
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void insert(){
        User user=new User();
        user.setUserId(1);
        user.setRegTime(new Date());
        user.setVersion("01");
        user.setAppId("appid1");
        userDao.insert(user);
    }

    @Test
    public void selectAll(){
        List<User> userList= userDao.selectAll();
        userList.forEach(user -> {
            System.out.println(user.getUserId());
        });
    }
    @Test
    public void deleteAll(){
        userDao.deleteAll();
    }
}