package com.example.lovecode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootTest
class LovecodeApplicationTests {

    @Test
    void contextLoads() {

        RestTemplate restTemplate = new RestTemplateBuilder().build();
        Object map = restTemplate.getForObject("https://www.baidu.com", Object.class);
        System.out.println(map);
    }

}
