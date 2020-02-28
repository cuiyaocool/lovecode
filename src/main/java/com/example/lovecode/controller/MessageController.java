package com.example.lovecode.controller;

import com.example.lovecode.jdbc.jpa.InformationDTO;
import com.example.lovecode.service.InformationService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cuiyaocy
 */
@RestController
public class MessageController {

    @Autowired
    private InformationService informationService;

    @GetMapping("/api/message")
    public List<InformationDTO> findAllMessage() {
        return informationService.findAll();
    }
}
