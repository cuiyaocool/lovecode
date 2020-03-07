package com.example.lovecode.controller;

import com.example.lovecode.exception.TestException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/api/test")
    public Object test() {
        throw new TestException();
    }
}
