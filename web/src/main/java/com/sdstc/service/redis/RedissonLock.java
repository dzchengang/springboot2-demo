package com.sdstc.service.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("redissonLock")
public class RedissonLock {
	@Autowired
	Redisson redisson;
	
	/**
	 * 加锁
	 * @param key
	 * @param timeout seconds
	 * @return
	 */
	public RLock getLock(String key,Long timeout) {
		RLock rlock=redisson.getLock(key);
		rlock.lock(timeout, TimeUnit.SECONDS);
		return rlock;
	}
	
	/**
	 * 释放锁
	 * @param key
	 */
	public void unclock(String key) {
		RLock rlock=redisson.getLock(key);
		if(rlock.isLocked()) {
			rlock.unlock();
		}
	}
}
