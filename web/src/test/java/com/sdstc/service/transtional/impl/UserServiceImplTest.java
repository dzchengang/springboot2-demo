package com.sdstc.service.transtional.impl;

import com.sdstc.Start;
import com.sdstc.service.transtional.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Start.class)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void insert() {
        userService.insert();
    }
}