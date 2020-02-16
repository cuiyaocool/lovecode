package com.example.lovecode.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登录操作接口", authorizations = {@Authorization("token")})
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @ApiOperation("用户名密码登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户名", name = "name", required = true, dataType = "String", defaultValue = "null", paramType = "query"),
            @ApiImplicitParam(value = "密码", name = "pw", required = true, dataType = "String", defaultValue = "null", paramType = "query")}
    )
    @RequestMapping("/bypw")
    public Object loginByPw(@RequestParam String name, @RequestParam String pw) {
        return null;
    }


}
