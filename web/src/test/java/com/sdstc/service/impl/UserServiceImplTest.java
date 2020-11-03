package com.sdstc.service.impl;

import com.sdstc.Start;
import com.sdstc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

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