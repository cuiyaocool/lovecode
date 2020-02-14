package com.example.lovecode.jdbc.mybatis.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.lovecode.jdbc.mybatis.Entity.UserEntity;
import lombok.Data;

@Data
public class UserExcel {
    @Excel(name = "姓名")
    private String name = "";

    @Excel(name = "工号")
    private String userId = "";

    @Excel(name = "手机号")
    private String mobile = "";

    public UserExcel(String name, String no, String mobile) {
        this.name = name;
        this.userId = no;
        this.mobile = mobile;
    }
    public UserExcel(UserEntity userEntity) {
        this.name = userEntity.getName();
        this.userId = "" + userEntity.getUserId();
        this.mobile = userEntity.getMobile();
    }
    public UserExcel() {}
}
