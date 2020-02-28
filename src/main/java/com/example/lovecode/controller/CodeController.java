package com.example.lovecode.controller;

import com.example.lovecode.service.CodeService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/api/code")
public class CodeController {

    @Autowired
    private CodeService codeService;

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
