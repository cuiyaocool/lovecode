package com.example.lovecode.controller;

import com.example.lovecode.jdbc.mybatis.dto.UserDTO;
import com.example.lovecode.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("根据id获得用户信息接口")
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Integer id) {
        System.out.println("id is : " + id);
        return userService.getUserById(id);
    }

    @ApiIgnore
    @PostMapping("/add/users/excel")
    public Object addUsersByExcel(@RequestParam MultipartFile file) {
        userService.addUsersByExcel(file);
        return "add success";
    }
}
