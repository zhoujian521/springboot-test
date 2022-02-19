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

    @PostMapping("/student/updateClass")
    public ResultDto uodateStuClass(Integer stuId, Integer oriClassId, Integer preClassId) {
        ResultDto result = new ResultDto();
        if (Objects.isNull(stuId) || Objects.isNull(oriClassId) || Objects.isNull(preClassId)) {
            result.setCode(-1011);
            result.setMsg("三个参数不可以为空");
            return result;
        }
        if (preClassId.intValue() == oriClassId.intValue()) {
            result.setCode(-1012);
            result.setMsg("两个班级的Id不能一样");
            return result;
        }
        ResultDto res = studentService.uodateStuClass(stuId, oriClassId, preClassId);
        return res;
    }




}
