package com.dt87.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemController {

    //系统公告跳转
    @RequestMapping("/toNoticeManager")
    public String notice() {
        return "system/notice/noticeManager";
    }

    //部门管理
    @RequestMapping("/toDeptManager")
    public String dept() {
        return "system/dept/deptManager";
    }

    @RequestMapping("/toDeptLeftManager")
    public String deptLeft() {
        return "system/dept/deptLeftManager";
    }

    @RequestMapping("/toDeptRightManager")
    public String deptRight() {
        return "system/dept/deptRightManager";
    }


    //查询菜单
    @RequestMapping("/toMenuManager")
    public String menu() {
        return "system/menu/menuManager";
    }

    @RequestMapping("/toMenuLeftManager")
    public String menuLeft() {
        return "system/menu/menuLeftManager";
    }

    @RequestMapping("/toMenuRightManager")
    public String menuRight() {
        return "system/menu/menuRightManager";
    }

    //权限管理
    @RequestMapping("/toPermissionManager")
    public String permission() {
        return "system/permission/permissionManager";
    }

    @RequestMapping("/toPermissionLeftManager")
    public String permissionLeft() {
        return "system/permission/permissionLeftManager";
    }

    @RequestMapping("/toPermissionRightManager")
    public String permissionRight() {
        return "system/permission/permissionRightManager";
    }


}
