package com.example.lovecode.jdbc.mybatis.dto;

import com.example.lovecode.jdbc.mybatis.Entity.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author cuiyaocy
 */
@Data
@ApiModel(value = "userDTO", description = "用户信息")
public class UserDTO {
    @ApiModelProperty(value = "用户Id", name = "userId", required = true, example = "1")
    private Integer userId;
    @ApiModelProperty(value = "姓名", name = "name", required = true, example = "baby")
    private String name;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("头像地址")
    private String avatarUrl;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("性别")
    private int gender;
    @ApiModelProperty("国家")
    private String country;
    @ApiModelProperty("省份")
    private String province;
    @ApiModelProperty("城市")
    private String city;
    @ApiModelProperty("生日")
    private Date birthday;
    @ApiModelProperty("邮箱")
    private String email;

    public UserDTO() {}
    public UserDTO(UserEntity data) {
        this.userId = data.getUserId();
        this.name = data.getName();
        this.nickName = data.getNickName();
        this.avatarUrl = data.getAvatarUrl();
        this.mobile = data.getMobile();
        this.gender = data.getGender();
        this.country = data.getCountry();
        this.province = data.getProvince();
        this.city = data.getCity();
        this.birthday = data.getBirthday();
        this.email = data.getEmail();
    }
}
