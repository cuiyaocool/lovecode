package com.example.demo.controller;

import com.example.demo.WebComment.CommonJsonResponse;
import com.example.demo.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuiyaocy
 */
@RestController
@RequestMapping("/api/token")
public class TokenController {

    @Autowired
    @Qualifier("tokenServiceImpl")
    private ITokenService tokenService;

    @RequestMapping(method = RequestMethod.GET)
    public CommonJsonResponse gettoken() {
        CommonJsonResponse res = new CommonJsonResponse();
        res.setMsg(CommonJsonResponse.MSG_SUCCESS);
        res.setErrorCode(CommonJsonResponse.ERROR_CODE_SUCCESS);
        res.setStatus(HttpStatus.OK.value());
        res.setData(tokenService.generateToken());
        return res;
    }
}