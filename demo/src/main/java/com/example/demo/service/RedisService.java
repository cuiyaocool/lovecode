package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author cuiyaocy
 */
@Repository

public class RedisService {

    @Autowired
    @Qualifier("myTemplate")
    private RedisTemplate redisTemplate;

    private final int expireTime = 2;

    public void setValues(final String key, Object value) {
        setValues(key, value, expireTime);
    }

    public void setValues(final String key, Object value, int expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.MINUTES);
    }

    public Optional<Object> getValue(final String key) {
        Object value = redisTemplate.opsForValue().get(key);
        if (value == null) {
            return Optional.empty();
        } else {
            return Optional.of(value);
        }
    }

    public boolean isExists(final String key) {
        return redisTemplate.hasKey(key);
    }

    public boolean delKey(final String key) {

        return redisTemplate.delete(key);
    }

}
