package com.sdstc.service.transtional;

import org.springframework.stereotype.Service;

@Service("testService")
public interface UserService {
    void insertUser();

    void insertOrg();

    void insert();
}
