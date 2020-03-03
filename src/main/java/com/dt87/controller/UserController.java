package com.dt87.controller;

import com.dt87.entity.JsonData;
import com.dt87.entity.Permission;
import com.dt87.entity.User;
import com.dt87.service.impl.PermissionServiceImpl;
import com.dt87.service.impl.UserServiceImpl;
import com.dt87.utils.TreeNode;
import com.dt87.utils.TreeNodeBuilder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PermissionServiceImpl permissionService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonData login(String username, String password, HttpSession session) {
        //先登录再验证
        User user = userService.login(username, password);

        if (user != null && user.getId() != null) {
            session.setAttribute("user", user);
            //shiro验证
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            return JsonData.buildSuccess(user, 0);
        }
        return JsonData.buildError("登录失败", -1);
    }

    //查询目录
    @RequestMapping("/menu")
    @ResponseBody
    public List<TreeNode> loadMenu() {
        List<Permission> permissionList = permissionService.loadMenu();
        List<TreeNode> list = new ArrayList<>();
        for (Permission p : permissionList) {
            TreeNode treeNode = new TreeNode(p.getId(), p.getPid(), p.getTitle(), p.getHref(), p.getIcon(), false);
            list.add(treeNode);
        }

        return TreeNodeBuilder.build(list, 1);
    }

}
