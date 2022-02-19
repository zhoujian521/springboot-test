package com.zjpower.springboot.controller;

import com.zjpower.springboot.dto.ResultDto;
import com.zjpower.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student/insert")
    public ResultDto insertStu(Integer classId, String className, String stuName) {
        ResultDto result = new ResultDto();
        if (Objects.isNull(classId) && Objects.isNull(className)) {
            result.setCode(-1006);
            result.setMsg("参数异常：班级id 班级名称 不可以同时为 null");
            return result;
        }
        ResultDto res = studentService.insertStu(classId, className, stuName);
        return res;
    }

    @PostMapping("/students/{count}")
    public ResultDto batchInsertStu(@PathVariable("count") Integer count) {
        if (Objects.isNull(count)) {
            count = 1;
        }
        ResultDto res = studentService.batchInsertStu(count);
        return res;
    }




}
