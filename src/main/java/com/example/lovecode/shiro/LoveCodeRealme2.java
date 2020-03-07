package com.example.lovecode.shiro;

import com.example.lovecode.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component("realme2")
public class LoveCodeRealme2 extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 获取角色和权限的方法，授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String mobile = (String)principals.getPrimaryPrincipal();
        System.out.println(("授权页面mobile : " + mobile));
        System.out.println(("realmes : " + principals.getRealmNames().toString()));
        List<String> roles = userService.getRoleListByMobile(mobile);
        System.out.println("role : " + roles);
        List<String> permissions = userService.getPermissionListByRole(roles);
        System.out.println("permissions : " + permissions);
        AuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        ((SimpleAuthorizationInfo) authorizationInfo).setRoles(roles.stream().collect(Collectors.toSet()));
        ((SimpleAuthorizationInfo) authorizationInfo).setStringPermissions(permissions.stream().collect(Collectors.toSet()));
        return authorizationInfo;
    }

    /**
     * 验证密码和用户名的方法，用于登录
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("token name = "+ token.getPrincipal() + "\n" + "token pw = " + new String((char[])(token.getCredentials())));
        String mobile = (String)token.getPrincipal();
        String dbpw = userService.getPasswordByMoblie(mobile);
        String tokenPw = new String((char[])(token.getCredentials()));

        if (tokenPw.equals(dbpw)) {
            System.out.println("getName is : " + getName());
            return new SimpleAuthenticationInfo(token.getPrincipal(), dbpw, getName());
        }
        return null;
    }
}
