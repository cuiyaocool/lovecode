package com.example.lovecode.controller;

import com.example.lovecode.exception.TestException;
import com.example.lovecode.jdbc.redis.UserData;
import com.example.lovecode.jdbc.redis.UserReidsResposity;
import com.example.lovecode.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class TestController extends AbstractController {

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

    @RequestMapping(value = "/api/test/model/kk/{userId}", method = RequestMethod.GET)
    public Object getSomeThing(@PathVariable(value = "userId") String userId ,Model model) {
        System.out.println("start");
        System.out.println(model.asMap());
        return model.toString();
    }

    @RequestMapping(value = "/api/test/model/tt", method = RequestMethod.GET)
    public Object getSomeThing1(@ModelAttribute String userID) {
        System.out.println("this userId is " + userID);
        return userID;
    }

    @RequestMapping(value = "/api/test/model/post", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Object postUserData(@ModelAttribute UserData data,Model model,@RequestBody UserData data1) {
        System.out.println(model);
        System.out.println(data);
        System.out.println(data1);
        return data;
    }
}
