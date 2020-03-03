package com.dt87.service.impl;

import com.dt87.entity.Permission;
import com.dt87.entity.Role;
import com.dt87.entity.User;
import com.dt87.mapper.PermissionMapper;
import com.dt87.mapper.RoleMapper;
import com.dt87.mapper.UserMapper;
import com.dt87.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    //登录
    @Override
    public User login(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        return userMapper.login(username, password);
    }

    //给用户授权操作
    public User sq(String username){
        //根据用户名查询用户
        User user = userMapper.findByName(username);
        //根据用户id查新角色表，将得到的用户角色放到用户对象中
        List<Role> roleList = roleMapper.finfByRid(user.getId());
        //根据角色id查询权限，将得到 的权限放入角色对象中
        for (int i = 0; i < roleList.size(); i++){
            List<Permission> permissionList = permissionMapper.findByPid(roleList.get(i).getId());
            roleList.get(i).setPermissionList(permissionList);
        }
        user.setRoleList(roleList);
        return user;
    }
}
