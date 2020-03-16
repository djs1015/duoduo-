package com.dt87.service.impl;

import com.dt87.entity.Role;
import com.dt87.mapper.RoleMapper;
import com.dt87.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    /**
     * 查询用户所有角色
     */
    @Override
    public List<Role> loadAllRole(Role role) {
        return roleMapper.loadAllRole(role);
    }

    @Override
    public int addRole(Role role) {
        return roleMapper.addRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public int batchDeleteRole(List<Serializable> list) {
        System.out.println("123456789");
        return roleMapper.batchDeleteRole(list);
    }

    /**
     * 给角色分配权限
     * @param role
     * @return
     */
    @Override
    public int saveRolePermission(Role role) {
        return roleMapper.saveRolePermission(role);
    }


}
