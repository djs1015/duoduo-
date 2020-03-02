package com.dt87.mapper;

import com.dt87.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
@Mapper
public interface NoticeMapper {
    //查询系统公告
    public List<Notice> findNotice(@Param("notice") Notice notice);

    //添加
    public int addNotice(@Param("notice") Notice notice);

    //修改
    public int updateNotice(@Param("notice") Notice notice);

    //删除单个
    public int deleteNotice(@Param("id") int id);

    //批量删除
    public int batchDeleteNotice(@Param("list") List<Serializable> list);

    //根据id查询公告
    public List<Notice> loadNoticeById(@Param("notice") Notice notice);
}
