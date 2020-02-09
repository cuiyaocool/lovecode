package com.example.lovecode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @RequestMapping("/bypw")
    public Object loginByPw(@RequestParam String name, @RequestParam String pw) {
        return null;
    }


}
