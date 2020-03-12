package com.dt87.controller;

import com.dt87.entity.JsonData;
import com.dt87.entity.Permission;
import com.dt87.service.impl.PermissionServiceImpl;
import com.dt87.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionServiceImpl permissionService;
    /**
     * 查询所有权限内容
     */
    @RequestMapping("/loadAllPermission")
    public JsonData loadAllPermission(Permission permission){
        return JsonData.buildSuccess(permissionService.loadAllPermission(permission),0);
    }
    /**
     * 添加权限
     */
    @RequestMapping("/addPermission")
    public JsonData addPermission(Permission permission){
        //获取当前选中的的父级的pid
        permissionService.loadAllMenuTreeJson(permission);
        try {
            int count = permissionService.addPermission(permission);
            if (count > 0) {
                return JsonData.buildSuccess(null, "添加成功");
            } else {
                return JsonData.buildError("添加失败", -1);
            }
        } catch (Exception e) {
            return JsonData.buildError("添加失败", -1);
        }
    }

    /**
     * 最大排序吗
     */
    @RequestMapping("/loadPermissionMaxOrderNum")
    public DataGridView loadPermissionMaxOrderNum(){
        Integer maxOrderNum = this.permissionService.loadPermissionMaxOrderNum();
        System.out.println("========================>>>>>>>>"+maxOrderNum);
        return new DataGridView(maxOrderNum+1);
    }

    /**
     * 删除数据
     */
    @RequestMapping("/deletePermission")
    public JsonData deletePermission(Integer id){
        try {
            permissionService.deletePermission(id);
            return JsonData.buildSuccess(null, "删除成功");
        } catch (Exception e) {
            return JsonData.buildError("删除失败", -1);
        }
    }


}
