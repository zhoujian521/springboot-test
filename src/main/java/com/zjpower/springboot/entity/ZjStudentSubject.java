package com.zjpower.springboot.entity;

import java.util.Date;
import lombok.Data;

/**
    * 学科表（自增id、科目名、创建时间、更新时间）
    */
@Data
public class ZjStudentSubject {
    /**
    * 自增id
    */
    private Integer id;

    /**
    * 科目名
    */
    private String subjectName;

    /**
    * 创建时间
    */
    private Date createdAt;

    /**
    * 更新时间
    */
    private Date updatedAt;
}