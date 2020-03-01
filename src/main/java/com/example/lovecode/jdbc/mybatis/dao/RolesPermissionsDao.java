package com.example.lovecode.jdbc.mybatis.dao;

import com.example.lovecode.jdbc.mybatis.Interface.RolesPermissionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RolesPermissionsDao {

    @Autowired
    private RolesPermissionsMapper mapper;

    public List<String> getPermissionsByRoleName(String roleName) {
        return mapper.getPermissionsByRoleName(roleName);
    }
}
