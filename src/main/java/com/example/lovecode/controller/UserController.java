package com.example.lovecode.controller;

import com.example.lovecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Object getUserById(@PathVariable Integer id) {
        System.out.println("id is : " + id);
        return userService.getUserById(id);
    }

    @PostMapping("/add/users/excel")
    public Object addUsersByExcel(@RequestParam MultipartFile file) {
        userService.addUsersByExcel(file);
        return "add success";
    }
}
