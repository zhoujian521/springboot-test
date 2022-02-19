package com.zjpower.springboot.entity;

import java.util.Date;
import lombok.Data;

/**
    * e.成绩表（自增id、学生id、考试id、学科id、成绩、创建时间、更新时间），其中学生id、考试id、学科id设置联合唯一索引
    */
@Data
public class ZjStudentGrades {
    /**
    * 自增id
    */
    private Integer id;

    /**
    * 学生id
    */
    private Integer studentId;

    /**
    * 考试id
    */
    private Integer examId;

    /**
    * 学科id
    */
    private Integer subjectId;

    /**
    * 成绩
    */
    private Double grades;

    /**
    * 创建时间
    */
    private Date createdAt;

    /**
    * 更新时间
    */
    private Date updatedAt;
}