package com.zjpower.springboot.entity;

import java.util.Date;
import lombok.Data;

/**
    * 学生表（自增id、姓名、班级id、创建时间、更新时间）
    */
@Data
public class ZjStudent {
    /**
    * 自增 id
    */
    private Integer id;

    /**
    * 姓名
    */
    private String studentName;

    /**
    * 班级id
    */
    private Integer classId;

    /**
    * 创建时间
    */
    private Date createdAt;

    /**
    * 更新时间
    */
    private Date updatedAt;
}