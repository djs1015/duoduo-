package com.dt87.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/transform")
@Controller
public class PramController {
    //登录成功，跳转到index主页面
    @RequestMapping("/index")
    public String index() {

        return "system/index";
    }

    //没有登录直接进主页，进不去，返回登录界面让其登录
    @RequestMapping("/need_login")
    public String toLogin() {

        return "system/login";
    }

    @RequestMapping("/toDeskManager")
    public String toDeskManager() {
        return "system/deskManager";
    }


}
