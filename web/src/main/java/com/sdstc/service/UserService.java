package com.sdstc.service;

import org.springframework.stereotype.Service;

@Service("testService")
public interface UserService {
    void insertUser();

    void insertOrg();

    void insert();
}
