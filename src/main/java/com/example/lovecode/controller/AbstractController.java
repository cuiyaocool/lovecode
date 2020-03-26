package com.example.lovecode.controller;

import com.example.lovecode.jdbc.redis.UserData;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

public class AbstractController {

    public static final String USER_ID = "userId";
    private static final String SCHOOL_ID = "schoolId";

    @ModelAttribute(USER_ID)
    public String getUserId(String userId) {
        System.out.println(userId);
        return "my" + userId;
    }

    @ModelAttribute(SCHOOL_ID)
    public String getSchoolId() {
        System.out.println("school");
        return "schoolId";
    }

    @ModelAttribute
    public UserData getClassId() {
        UserData userData = new UserData();
        userData.setUserId("id");
        Map<String, String> map = new HashMap<>();
        map.put("test", "test1");
        userData.setData(map);
        System.out.println(userData);
        return userData;
    }



}
