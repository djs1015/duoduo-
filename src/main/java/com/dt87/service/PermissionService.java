package com.dt87.service;

import com.dt87.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionService {
    public List<Permission> findByPid(int pid);

    public List<Permission> loadMenu();
}
