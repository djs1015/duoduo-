package com.dt87.service.impl;

import com.dt87.entity.Permission;
import com.dt87.mapper.PermissionMapper;
import com.dt87.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findByPid(int pid) {
        return permissionMapper.findByPid(pid);
    }

    @Override
    public List<Permission> loadMenu() {
        return permissionMapper.loadMenu();
    }

    //查看所有权限（并生成树）
    @Override
    public List<Permission> loadAllMenuTreeJson(Permission permission){
        return permissionMapper.loadAllMenuTreeJson(permission);
    }

    //查询所有权限内容
    @Override
    public List<Permission> loadAllPermission(Permission permission) {

        return permissionMapper.loadAllPermission(permission);
    }

    //添加权限
    @Override
    public int addPermission(Permission permission) {
        return permissionMapper.addPermission(permission);
    }

    @Override
    public int loadPermissionMaxOrderNum() {
        return permissionMapper.loadPermissionMaxOrderNum();
    }

    @Override
    public Integer deletePermission(Integer id) {
        return permissionMapper.deletePermission(id);
    }

    /**
     * 查询所有权限列表
     * @param permission
     * @return
     */
    @Override
    public List<Permission> loadRolePermission(Permission permission) {
        return permissionMapper.loadRolePermission(permission);
    }


}
