package com.example.lovecode.shiro;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component("loveCodeRealme")
public class LoveCodeRealme extends JdbcRealm {

    @Autowired
    DataSource dataSource;

    protected String authenticationQuery = "select password from userinfo where mobile = ?";

    protected String userRolesQuery = "select role as role_name from user_role ur left join userinfo on ur.userid = userinfo.`userId` where mobile = ?";

    protected String permissionsQuery = "select permission from roles_permissions where role_name = ?";

    {
        this.setAuthenticationQuery(authenticationQuery);
        this.setUserRolesQuery(userRolesQuery);
        this.setPermissionsQuery(permissionsQuery);
    }
}
