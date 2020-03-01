package com.example.lovecode.jdbc.mybatis.Interface;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolesPermissionsMapper {

    List<String> getPermissionsByRoleName(String roleName);
}
