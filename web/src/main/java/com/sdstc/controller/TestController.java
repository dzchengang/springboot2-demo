package com.sdstc.controller;

import com.sdstc.service.event.EventService;
import com.sdstc.service.transtional.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private EventService eventService;

    @RequestMapping("/test")
    public String test(String id) {
        testService.test1();
       // eventService.test();
        return "a";
    }

}
