package com.dt87.controller;

import com.dt87.entity.JsonData;
import com.dt87.entity.Notice;
import com.dt87.entity.User;
import com.dt87.service.impl.NoticeServiceImpl;
import com.dt87.utils.DataGridView;
import com.dt87.vo.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeServiceImpl noticeService;

    /**
     * 查询系统公告
     */
    @RequestMapping("/loadAllNotice")
    @ResponseBody
    public JsonData findNotice(Notice notice) {
        return JsonData.buildSuccess(noticeService.findNotice(notice), 0);
    }

    /**
     * 添加公告
     */
    @RequestMapping("/addNotice")
    @ResponseBody
    public JsonData addNotice(Notice notice, HttpSession session) {
        //创建时间
        notice.setCreatetime(new Date());
        User user = (User) session.getAttribute("user");
        notice.setOpername(user.getName());
        try {
            int count = noticeService.addNotice(notice);
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
     * 修改公告
     */
    @RequestMapping("/updateNotice")
    @ResponseBody
    public JsonData updateNotice(Notice notice) {
        if (notice.getTitle() != null && !notice.getTitle().equals("") && notice.getContent() != null && !notice.getContent().equals(""))
            try {
                noticeService.updateNotice(notice);
                return JsonData.buildSuccess(null, "修改成功");
            } catch (Exception e) {
                return JsonData.buildError("修改失败", -1);
            }
        else {
            return JsonData.buildError("修改失败", -1);
        }
    }

    /**
     * 删除单个公告
     */
    @RequestMapping("/deleteNotice")
    @ResponseBody
    public JsonData deleteNotice(int id) {
        try {
            noticeService.deleteNotice(id);
            return JsonData.buildSuccess(null, "删除成功");
        } catch (Exception e) {
            return JsonData.buildError("删除失败", -1);
        }
    }

    /**
     * 批量删除公告
     */
    @RequestMapping("/batchDeleteNotice")
    @ResponseBody
    public JsonData batchDeleteNotice(int[] ids) {
        List<Serializable> list = new ArrayList<Serializable>();
        for (int i = 0; i < ids.length; i++) {
            list.add(ids[i]);
        }
        try {
            noticeService.batchDeleteNotice(list);
            return JsonData.buildSuccess(null, "批量删除成功");
        } catch (Exception e) {
            return JsonData.buildError("批量删除失败", -1);
        }

    }

    /**
     * 首页查询单个公告
     */
    @RequestMapping("/loadNoticeById")
    @ResponseBody
    public JsonData loadNoticeById(Notice notice) {
        return JsonData.buildSuccess(noticeService.loadNoticeById(notice), 0);
    }

}
