package com.sdstc.redisson.lock;

import java.util.Collection;

import org.redisson.Redisson;
import org.redisson.api.Node;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RedisController {
	@Autowired
	private RedisDao redisDao;
	@Autowired
	Redisson redisson;
	@Autowired
	RedissonClient redissonClient;
	
	
	@GetMapping("/test")
	public String sendReq() {
		Collection<Node> nodes=redissonClient.getNodesGroup().getNodes();
		for(Node node:nodes) {
			System.out.println(node.getAddr());
		}
		redisDao.setKey("a", "b", 10000);
		System.out.println(redisDao.getValue("a"));
		return "sucess";
	}
}
