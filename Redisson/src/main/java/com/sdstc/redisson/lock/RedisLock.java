package com.sdstc.redisson.lock;

import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("redisLock")
public class RedisLock {
	@Autowired
    Redisson redisson;
	@Autowired
	RedissonClient  redissonClient;
    
	public void tetLock() {
		RLock rlock= redisson.getLock("test1");
		rlock.lock(10, TimeUnit.SECONDS);
		
		Integer stock=this.getValue("stock",Integer.class);
		if(stock==null) {
			this.setValue("stock", 1000,Integer.class);
		}else {
            System.out.println(stock);
            stock=stock-1;
            this.setValue("stock", stock,Integer.class);
		}
		
		rlock.unlock();
	}
	
	
	public <T> T getValue(String key,Class<T> valueClazz) {
		RBucket<T> value=redissonClient.getBucket(key);
		return value.get();
	}
	
	public  <T> void setValue(String key,Object value,Class<T> valueClazz) {
		RBucket<T> keyVal=redissonClient.getBucket(key);
		keyVal.set((T)value);
	}
}
