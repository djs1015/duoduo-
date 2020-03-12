package com.dt87.controller;

import com.dt87.entity.Dept;
import com.dt87.entity.JsonData;
import com.dt87.service.impl.DeptServiceImpl;
import com.dt87.utils.DataGridView;
import com.dt87.utils.TreeNode;
import com.dt87.utils.TreeNodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
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
    @ResponseBody
    public DataGridView loadAllDeptTreeJson(Dept dept) {
        List<Dept> deptList = deptService.loadAllDeptTreeJson(dept);
        System.out.println("======================"+deptList);
        List<TreeNode> list = new ArrayList<>();
        for (Dept d : deptList) {
           /* TreeNode treeNode = new TreeNode(d.getId(), d.getPid(), d.getTitle(), false);
            list.add(treeNode);*/
            Integer id=d.getId();
            Integer pid=d.getPid();
            String title=d.getTitle();
            Boolean spread=d.getOpen()==1?true:false;
            list.add(new TreeNode(id, pid, title, spread));
        }

        return new DataGridView(list);
    }
    /**
     * 添加部门
     */
    @RequestMapping("/addDept")
    @ResponseBody
    public JsonData addDept(Dept dept){
        //创建时间
        dept.setCreatetime(new Date());
        //获取当前选中的的父级部门的pid

        deptService.loadAllDeptTreeJson(dept);
        try {
            int count = deptService.addDept(dept);
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
     * 加载最大排序吗
     */
    @RequestMapping("/loadDeptMaxOrderNum")
    @ResponseBody
    public DataGridView loadDeptMaxOrderNum(){
        Integer maxOrderNum = this.deptService.loadDeptMaxOrderNum();
        return new DataGridView(maxOrderNum+1);
    }



}
