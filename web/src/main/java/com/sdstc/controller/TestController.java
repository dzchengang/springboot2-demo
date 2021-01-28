package com.sdstc.controller;

import com.sdstc.service.event.EventService;
import com.sdstc.service.redis.RedisDao;
import com.sdstc.service.transtional.TestService;
import org.redisson.Redisson;
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

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private Redisson redisson;


    @RequestMapping("/test")
    public String test(String id) {
        testService.test1();
       // eventService.test();
        return "a";
    }


    @RequestMapping("/redis")
    public String redis(String id) {
        if(redisDao.getSet("14456","123",100,100)){
            System.out.println("aa");
        }else{
            System.out.println("bb");
        }
        return "a";
    }

}
