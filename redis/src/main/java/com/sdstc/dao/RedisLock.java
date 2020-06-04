package com.sdstc.dao;

import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component("redisLock")
public class RedisLock {
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 加锁
	 * @param key
	 * @param value
	 * @param timeout
	 * @return
	 */
	public Boolean getLock(String key,Object value,Long timeout) {
		Boolean result = redisTemplate.opsForValue().setIfAbsent(key, value, timeout, TimeUnit.SECONDS);
		return result;
	}
	/**
	 * 加锁
	 * @param key
	 * @return
	 */
	public Boolean getLock(String key) {
		return this.getLock(key, 1, 60L);
	}
	/**
	 * 释放锁
	 * @param key
	 */
	public void unclock(String key) {
		redisTemplate.delete(key);
	}
}
