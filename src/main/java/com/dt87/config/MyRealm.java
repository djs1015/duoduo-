package com.dt87.config;

import com.dt87.entity.Permission;
import com.dt87.entity.Role;
import com.dt87.entity.User;
import com.dt87.service.impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserServiceImpl userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        //根据用户信息查询角色和对应权限
        Set<String> permissions = new HashSet<>();
        Set<String> roles = new HashSet<>();
        String username = (String) principalCollection.getPrimaryPrincipal();
        //获取role
        List<Role> roles1 = userService.sq(username).getRoleList();
        for (Role r : roles1) {
            roles.add(r.getName());
            for (Permission p : r.getPermissionList()) {
                permissions.add(p.getPercode());
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        //获取用户名信息
        String username = (String) authenticationToken.getPrincipal();
        User user = userService.findByName(username);
        if (user.getPwd() == null) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, user.getPwd(), this.getClass().getName());
        return simpleAuthenticationInfo;
    }
}
