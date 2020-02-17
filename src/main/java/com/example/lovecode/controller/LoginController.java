package com.example.lovecode.controller;

import io.swagger.annotations.*;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "登录操作接口", authorizations = {@Authorization("token")})
@RestController
@RequestMapping(value = "/api/login",produces = "application/json;charset=UTF-8")
public class LoginController {

    @ApiOperation("用户名密码登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户名", name = "name", required = true, dataType = "String", defaultValue = "null", paramType = "query"),
            @ApiImplicitParam(value = "密码", name = "pw", required = true, dataType = "String", defaultValue = "null", paramType = "query")}
    )
    @PostMapping("/bypw")
    public Object loginByPw(@RequestBody String name, @RequestBody String pw) {
        return name+pw;
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
