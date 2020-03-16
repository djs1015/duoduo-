package com.dt87.service;

import com.dt87.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionService {
    public List<Permission> findByPid(int pid);

    public List<Permission> loadMenu();

    public List<Permission> loadAllMenuTreeJson(Permission permission);

    public List<Permission> loadAllPermission(Permission permission);

    public int addPermission(Permission permission);

    public int loadPermissionMaxOrderNum();

    public Integer deletePermission(Integer id);

    public List<Permission> loadRolePermission(Permission permission);
}
