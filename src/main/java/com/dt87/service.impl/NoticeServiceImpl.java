package com.dt87.service.impl;

import com.dt87.entity.Notice;
import com.dt87.mapper.NoticeMapper;
import com.dt87.service.NoticeService;
import com.dt87.vo.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    //查询公告
    @Override
    public List<Notice> findNotice(Notice notice) {
        return noticeMapper.findNotice(notice);
    }

    //添加
    @Override
    public int addNotice(Notice notice) {
        return noticeMapper.addNotice(notice);
    }

    //修改
    @Override
    public int updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }

    @Override
    public int deleteNotice(int id) {
        return noticeMapper.deleteNotice(id);
    }

    @Override
    @Transactional
    public int batchDeleteNotice(List<Serializable> list) {
        return noticeMapper.batchDeleteNotice(list);
    }

    //根据id查询公告
    @Override
    public List<Notice> loadNoticeById(Notice notice) {
        return noticeMapper.loadNoticeById(notice);
    }
}
