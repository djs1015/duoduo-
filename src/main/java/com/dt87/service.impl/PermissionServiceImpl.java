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
}
