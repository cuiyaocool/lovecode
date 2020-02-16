package com.example.lovecode.controller;

import com.example.lovecode.common.Constants;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuiyaocy
 */
@Api(tags = "Index接口")
@RestController
@RequestMapping("/api/index")
public class IndexController {

    @GetMapping("/status")
    public String index() {
        return Constants.INDEX_STATUS;
    }
}
