package com.sdstc.controller;

import com.sdstc.dto.PolicyDto;
import com.sdstc.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private PolicyService policyService;

    @RequestMapping("/token")
    public PolicyDto token() throws UnsupportedEncodingException {
        return policyService.test();
    }
}
