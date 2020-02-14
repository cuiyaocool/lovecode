package com.example.lovecode.jdbc.mybatis.Entity;

import lombok.Data;

import java.util.Date;

@Data
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

}
