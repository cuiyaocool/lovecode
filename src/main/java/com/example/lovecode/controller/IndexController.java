package com.example.lovecode.controller;

import com.example.lovecode.common.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/index")
public class IndexController {
    @GetMapping("/status")
    public String index() {
        return Constants.INDEX_STATUS;
    }
}
