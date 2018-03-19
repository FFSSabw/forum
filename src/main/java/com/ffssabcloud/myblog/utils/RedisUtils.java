package com.ffssabcloud.myblog.utils;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {
    
    @Autowired
    StringRedisTemplate redisTemplate;
    
    public void remove(String... keys) {
        for(String key : keys) {
            remove(key);
        }
    }
    
    public void remove(String key) {
        if(exists(key)) {
            redisTemplate.delete(key);
        }
    }
    
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }
    
    public boolean setStr(String key, String value)  {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
}
