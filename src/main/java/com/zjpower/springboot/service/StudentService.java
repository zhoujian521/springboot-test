package com.zjpower.springboot.service;

import com.zjpower.springboot.dto.ResultDto;

public interface StudentService {
    ResultDto insertStu(Integer classId, String className, String stuName);

    ResultDto batchInsertStu(Integer count);
}
