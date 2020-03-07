package com.example.lovecode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author cuiyaocy
 */
@Service
public class RedisService {

    @Autowired
    @Qualifier("myTemplate")
    private RedisTemplate template;

    public Object getValue(String key) {
        return template.opsForValue().get(key);
    }

    public Boolean setValue(String key, Object value) {
        if (template == null) {
            return Boolean.FALSE;
        }
        template.opsForValue().set(key, value, 2, TimeUnit.MINUTES);
        return Boolean.TRUE;
    }
}
