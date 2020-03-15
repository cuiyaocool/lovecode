package com.example.lovecode.controller;

import com.example.lovecode.exception.TestException;
import com.example.lovecode.jdbc.redis.UserData;
import com.example.lovecode.jdbc.redis.UserReidsResposity;
import com.example.lovecode.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private RedisService redisService;

    @Autowired
    @Qualifier("userRedis")
    private UserReidsResposity reidsResposity;

    @RequestMapping("/api/test")
    public Object test() {
        throw new TestException();
    }

    @RequestMapping("/api/redis")
    public UserData getUsers() {
        Iterable<UserData> list = reidsResposity.findAll();
        list.forEach(u -> System.out.println(u));
        Optional data = reidsResposity.findById("1");
        if (data.isPresent()) {
            System.out.println(data);
        } else {
            System.out.println("没有1");
        }
        Optional<UserData> data1 = reidsResposity.findById("2");
        if (data1.isPresent()) {
            System.out.println(data1.get());
        } else {
            System.out.println("没有2");
        }
        Optional<UserData> data2 = reidsResposity.findById("3");
        return data1.get();
    }
}
