package com.example.lovecode.controller;

import io.swagger.annotations.*;
import lombok.Data;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

@Api(tags = "登录操作接口", authorizations = {@Authorization("token")})
@RestController
@RequestMapping(value = "/api/login",produces = "application/json;charset=UTF-8")
public class LoginController {

    @ApiOperation("用户名密码登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户名", name = "name", required = true, dataType = "String", defaultValue = "null", paramType = "query"),
            @ApiImplicitParam(value = "密码", name = "pw", required = true, dataType = "String", defaultValue = "null", paramType = "query")}
    )
    @RequestMapping(method = RequestMethod.GET)
    public Object loginByPw(@RequestParam("username") String username, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        if (subject == null) {
            return "subject is null";
        }
        System.out.println("login message is :" + username + "" + password);
        subject.login(token);
        System.out.println(subject.releaseRunAs());
        return "ok";
    }
    @PostMapping("/bypw1")
    public Integer loginByPw1(@RequestBody ddd map) {


        return map.getPw();
    }

    @Data
    public static class ddd {
        String name;
        Integer pw;
    }

}
