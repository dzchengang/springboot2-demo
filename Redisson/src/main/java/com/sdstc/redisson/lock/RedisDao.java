package com.sdstc.redisson.lock;


import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author cheng
 */
@Repository
public class RedisDao {
	@Autowired
	Redisson redisson;
	@Autowired
	RedissonClient redissonClient;

	public void setKey(String key, String value, long timeout) {
		RBucket<String> keyVal = redissonClient.getBucket(key);
		keyVal.set(value, timeout, TimeUnit.MILLISECONDS);
	}

	public String getValue(String key) {
		RBucket<String> value = redissonClient.getBucket(key);
		return value.get();
	}

	public <T> T getValue(String key, Class<T> valueClazz) {
		RBucket<T> value = redissonClient.getBucket(key);
		return value.get();
	}

	public <T> void setValue(String key, Object value, Class<T> valueClazz) {
		RBucket<T> keyVal = redissonClient.getBucket(key);
		keyVal.set((T) value);
	}

	public void delKey(String key) {
		RBucket keyVal = redissonClient.getBucket(key);
		keyVal.delete();
	}
}