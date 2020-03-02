package com.dt87.controller;

import com.dt87.entity.Dept;
import com.dt87.entity.JsonData;
import com.dt87.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptServiceImpl deptService;

    /**
     * 查询部门
     */
    @RequestMapping("/loadAllDept")
    @ResponseBody
    public JsonData loadAllDept(Dept dept) {
        return JsonData.buildSuccess(deptService.loadAllDept(dept), 0);
    }

    /**
     * 生成json树
     */
    @RequestMapping("/loadAllDeptTreeJson")
    public JsonData loadAllDeptTreeJson() {

        return JsonData.buildSuccess();
    }


}
