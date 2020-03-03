package com.dt87.vo;

import java.io.Serializable;
import java.util.Date;

import com.dt87.entity.Notice;
import org.springframework.format.annotation.DateTimeFormat;


public class NoticeVo extends Notice implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 分页参数
     */
    private Integer page = 1;
    private Integer limit = 10;

    /**
     * 查询条件
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
