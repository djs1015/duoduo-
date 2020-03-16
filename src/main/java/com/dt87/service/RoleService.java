package com.dt87.service;

import com.dt87.entity.Role;

import java.io.Serializable;
import java.util.List;

public interface RoleService {
    public List<Role> loadAllRole(Role role);

    public int addRole(Role role);

    public int updateRole(Role role);
    public int batchDeleteRole(List<Serializable> list);
    public int saveRolePermission(Role role);
}
