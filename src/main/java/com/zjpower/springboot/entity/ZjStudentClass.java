package com.zjpower.springboot.entity;

import java.util.Date;
import lombok.Data;

@Data
public class ZjStudentClass {
    /**
    * 自增id
    */
    private Integer id;

    /**
    * 班级名称
    */
    private String className;

    /**
    * 创建时间
    */
    private Date createdAt;

    /**
    * 更新时间
    */
    private Date updatedAt;
}