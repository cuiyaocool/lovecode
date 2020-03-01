package com.example.lovecode.jdbc.mybatis.dao;

import com.example.lovecode.jdbc.mybatis.Entity.UserEntity;
import com.example.lovecode.jdbc.mybatis.Interface.UserMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDao {
    @Resource
    private UserMapper userMapper;

    public UserEntity getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public UserEntity getUserByMobile(String mobile) {
        return userMapper.getUserByMobile(mobile);
    }
}
