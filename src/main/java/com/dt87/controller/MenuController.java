package com.dt87.controller;

import com.dt87.entity.Permission;
import com.dt87.service.impl.PermissionServiceImpl;
import com.dt87.utils.DataGridView;
import com.dt87.utils.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    /**
     * 查看所有权限（并生成树）
     */
    @Autowired
    private PermissionServiceImpl permissionService;

    @RequestMapping("/loadAllMenuTreeJson")
    public DataGridView loadAllMenuTreeJson(Permission permission){
        List<Permission> permissionList = permissionService.loadAllMenuTreeJson(permission);
        //System.out.println("======================"+permissionList);
        List<TreeNode> list = new ArrayList<>();
        for (Permission p : permissionList) {
            Integer id = p.getId();
            Integer pid = p.getPid();
            String title = p.getTitle();
            Boolean spread = p.getOpen()==1?true:false;
            list.add(new TreeNode(id, pid, title, spread));
        }
        return new DataGridView(list);
    }

}
