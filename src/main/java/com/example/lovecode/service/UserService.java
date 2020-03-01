package com.example.lovecode.service;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.lovecode.jdbc.mybatis.dao.RolesPermissionsDao;
import com.example.lovecode.jdbc.mybatis.dao.UserDao;
import com.example.lovecode.jdbc.mybatis.Entity.UserEntity;
import com.example.lovecode.jdbc.mybatis.dao.UserRoleDao;
import com.example.lovecode.jdbc.mybatis.dto.UserDTO;
import com.example.lovecode.jdbc.mybatis.excel.UserExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RolesPermissionsDao rolesPermissionsDao;

    public List<String> getRoleListByMobile(String mobile) {
        UserEntity userEntity = userDao.getUserByMobile(mobile);
        return getRoleListById(userEntity.getUserId());
    }

    public String getPasswordByMoblie(String mobile) {
        UserEntity userEntity = userDao.getUserByMobile(mobile);
        return userEntity.getPassword();
    }

    public List<String> getRoleListById(int userId) {
        System.out.println("userId is : " + userId);
        return userRoleDao.getUserRoleListById(userId);
    }

    public List<String> getPermissionListByRole(List<String> roles) {
        List<String> permissionList = new ArrayList<>();
        for (String role : roles) {
            List<String> tmp = rolesPermissionsDao.getPermissionsByRoleName(role);
            permissionList.addAll(tmp);
        }
        return permissionList;
    }
    public UserDTO getUserById(Integer id) {
        UserEntity userEntity = userDao.getUserById(id);
        if (userEntity == null) {
            return null;
        }
        return new UserDTO(userEntity);
    }

    public void addUsersByExcel(MultipartFile file) {
        System.out.println("sdfsfs");
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        String[] strings = new String[]{"姓名","工号","手机号"};
        params.setImportFields(strings);
        if (file == null) {
            System.out.println("file is null");
        }
        try (InputStream inputStream = file.getInputStream()) {
            System.out.println("kaishi");
            List<UserExcel> list = ExcelImportUtil.importExcel(inputStream, UserExcel.class, params);
            System.out.println("ddd");
            if (list == null) {
                System.out.println("null");
            }
            for (UserExcel data : list) {
                System.out.println(data);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
