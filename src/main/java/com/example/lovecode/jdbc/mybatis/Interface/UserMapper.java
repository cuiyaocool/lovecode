package com.example.lovecode.jdbc.mybatis.Interface;

import com.example.lovecode.jdbc.mybatis.Entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    //@Select("select * from userInfo where userId=#{id}")
    UserEntity getUserById(@Param("id") Integer id);
}
