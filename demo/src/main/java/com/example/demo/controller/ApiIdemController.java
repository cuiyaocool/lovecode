package com.example.demo.controller;

import com.example.demo.WebComment.CommonJsonResponse;
import com.example.demo.annotation.ApiIdempotent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuiyaocy
 * @desc 幂等接口
 */
@RestController
public class ApiIdemController {

    @ApiIdempotent
    @RequestMapping("/api/repeate")
    public CommonJsonResponse repeatetest() {

        return new CommonJsonResponse();
    }
}
