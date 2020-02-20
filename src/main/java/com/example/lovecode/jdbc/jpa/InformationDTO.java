package com.example.lovecode.jdbc.jpa;

import com.example.lovecode.annotation.NeedSetValue;
import com.example.lovecode.jdbc.jpa.entity.InformationEntity;
import com.example.lovecode.jdbc.mybatis.dao.UserDao;
import lombok.Data;

/**
 * @author cuiyaocy
 */
@Data
public class InformationDTO {
    Integer id;
    String message;
    Integer userId;
    @NeedSetValue(benaclass = UserDao.class, param = "userId", method = "getUserById", targetFild = "name")
    String name;

    public InformationDTO(InformationEntity entity) {
        this.id = entity.getId();
        this.message = entity.getMessage();
        this.userId = entity.getUserId();
        this.name = null;
    }
}
