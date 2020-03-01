package com.example.lovecode.jdbc.mybatis.dao;

import com.example.lovecode.jdbc.mybatis.Interface.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRoleDao {
    @Autowired
    UserRoleMapper mapper;

    public List<String> getUserRoleListById(int userId) {
        return mapper.getUserRoleListById(userId);
    }
}
