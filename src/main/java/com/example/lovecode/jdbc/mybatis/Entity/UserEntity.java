package com.example.lovecode.jdbc.mybatis.Entity;

import com.example.lovecode.annotation.TestAnnotation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserEntity {
    private Integer userId;
    private String name;
    private String nickName;
    private String avatarUrl;
    private String mobile;
    private int gender;
    private String country;
    private String province;
    private String city;
    private String password;
    private Date birthday;
    private int status;
    private String email;

    @TestAnnotation
    public UserEntity(String name) {
        this.name = name;
    }
}
