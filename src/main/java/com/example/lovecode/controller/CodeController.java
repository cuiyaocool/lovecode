package com.example.lovecode.controller;

import com.example.lovecode.jdbc.redis.UserData;
import com.example.lovecode.jdbc.redis.UserReidsResposity;
import com.example.lovecode.service.CodeService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/code")
public class CodeController {

    @Autowired
    private CodeService codeService;

    @Autowired
    @Qualifier("userRedis")
    private UserReidsResposity reidsResposity;

    @RequestMapping("/generate")
    public void genarate(@RequestParam String message, HttpServletResponse response) throws IOException {
        System.out.println("收到消息： " + message);
        byte[] bytes = codeService.genarate(message);
        OutputStream outputStream = null;
        try {
            response.setContentType("image/jpeg");
            outputStream = response.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            System.out.println(bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
        UserData user1 = new UserData();
        user1.setUserId("1");
        Map<String, String> data = new HashMap<>();
        data.put("test1", "test1Value");
        reidsResposity.save(user1);
        UserData user2 = new UserData();
        user2.setUserId("2");
        data.clear();
        data.put("test2", "test2Value");
        reidsResposity.save(user2);
        UserData user3 = new UserData();
        user3.setUserId("3");
        reidsResposity.save(user3);
    }

    @RequestMapping("/imagetest")
    public void test(HttpServletResponse response) throws IOException {
        OutputStream outputStream = response.getOutputStream();
        File file = new File("D:\\code.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        while (fileInputStream.read(bytes) != -1) {
            outputStream.write(bytes);
        }
        outputStream.flush();
    }
}
