package com.sdstc.service.redis;

import org.redisson.api.RBucket;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author cheng
 */
@Repository
public class RedisDao {
    @Autowired
    RedissonClient redissonClient;
    @Autowired
    RedissonLock redissonLock;

    public boolean getSet(String key, String value, long lockTimeout, long timeout) {
        boolean pass = false;
        String lockKey = key + "a";

        redissonLock.getLock(lockKey, lockTimeout);
        if (!value.equals(this.getValue(key))) {
            this.setKey(key, value, timeout * 1000);
            pass = true;
        } else {
            pass = false;
        }
        redissonLock.unclock(lockKey);
        return pass;
    }

    public void setKey(String key, String value) {
        RBucket<String> keyVal = redissonClient.getBucket(key);
        keyVal.set(value);
    }

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

    public <T> void setValue(String key, Object value, Class<T> valueClazz, long timeout) {
        RBucket<T> keyVal = redissonClient.getBucket(key);
        keyVal.set((T) value, timeout, TimeUnit.MILLISECONDS);
    }


}