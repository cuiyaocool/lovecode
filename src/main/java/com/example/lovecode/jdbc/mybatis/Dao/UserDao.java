package com.example.lovecode.jdbc.mybatis.Dao;

import com.example.lovecode.jdbc.mybatis.Entity.UserEntity;
import com.example.lovecode.jdbc.mybatis.Interface.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDao {
    @Resource
    private UserMapper userMapper;

    public UserEntity getUserById(Integer id) {
        return userMapper.getUserById(id);
    }
}
