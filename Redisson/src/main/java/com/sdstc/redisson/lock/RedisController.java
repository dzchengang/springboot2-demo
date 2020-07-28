package com.sdstc.redisson.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RedisController {
	@Autowired
	private RedissonLock redissonLock;
	
	
	
	@GetMapping("/test")
	public String sendReq() throws InterruptedException {
		redissonLock.getLock("a", 2L);
		
		Thread.sleep(1000);
		
		redissonLock.unclock("a");
		return "sucess";
	}
}
