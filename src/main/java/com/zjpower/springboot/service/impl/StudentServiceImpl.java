package com.zjpower.springboot.service.impl;

import com.zjpower.springboot.dao.ZjStudentClassMapper;
import com.zjpower.springboot.dao.ZjStudentGradesMapper;
import com.zjpower.springboot.dao.ZjStudentMapper;
import com.zjpower.springboot.dao.ZjStudentSubjectMapper;
import com.zjpower.springboot.dto.ResultDto;
import com.zjpower.springboot.entity.ZjStudent;
import com.zjpower.springboot.entity.ZjStudentClass;
import com.zjpower.springboot.entity.ZjStudentGrades;
import com.zjpower.springboot.entity.ZjStudentSubject;
import com.zjpower.springboot.service.StudentService;
import com.zjpower.springboot.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    ZjStudentMapper zjStudentMapper;
    @Autowired
    ZjStudentClassMapper zjStudentClassMapper;
    @Autowired
    ZjStudentSubjectMapper subjectMapper;
    @Autowired
    ZjStudentGradesMapper gradesMapper;

    @Override
    @Transactional
    public ResultDto insertStu(Integer classId, String className, String stuName) {
        // 根据 classId || className => class
        ZjStudentClass stuClass = null;
        if (!Objects.isNull(classId)) {
            stuClass = zjStudentClassMapper.selectByPrimaryKey(classId);
        } else {
            stuClass = zjStudentClassMapper.selectByClassName(className);
        }
        ResultDto result = new ResultDto();
        // 班级不存在
        if (Objects.isNull(stuClass)) {
            result.setCode(-1007);
            result.setMsg("找不到对应的班级");
            return result;
        }
        // 该学生是否已在当前班级
        List<ZjStudent> students = zjStudentMapper.selectByClassIdAndStuName(stuClass.getId(), stuName);
        if (students.size() != 0) {
            result.setCode(-1008);
            result.setMsg("该学生已加入该班级无需重复加入");
            return result;
        }
        // 学生加入班级
        ZjStudent stu = new ZjStudent();
        stu.setClassId(stuClass.getId());
        stu.setStudentName(stuName);
        int res = zjStudentMapper.insertSelective(stu);
        result.setData(res);
        result.setMsg("插入成功");
        return result;
    }

    @Override
    @Transactional
    public ResultDto batchInsertStu(Integer total) {
        List<ZjStudent> students = new ArrayList<>();
        List<ZjStudentClass> classes = zjStudentClassMapper.selectAllClass();

        ResultDto result = new ResultDto();
        Random random = new Random();
        for (int i = 0; i < total; i++) {
            // 在a-z中随机6-10个字符，拼接为名称
            String stuName = Utils.getRandomString(6, 10);
            // 随机班级Id
            int index = random.nextInt(classes.size());
            int classId = classes.get(index).getId();
            // 组装新学生
            ZjStudent stu = new ZjStudent();
            stu.setStudentName(stuName);
            stu.setClassId(classId);
            students.add(stu);
        }
        // 批量插入
        int res = zjStudentMapper.batchInsertStudents(students);
        result.setData(res);
        result.setMsg("批量插入学员成功");
        return result;
    }

    @Override
    @Transactional
    public ResultDto uodateStuClass(Integer stuId, Integer oriClassId, Integer preClassId) {
        // bug 学生可能不在原班级 ？？？
        ResultDto result = new ResultDto();
        ZjStudent student = zjStudentMapper.selectByPrimaryKey(stuId);
        if (Objects.isNull(student)) {
            result.setCode(-1014);
            result.setMsg("学员数据库中不存在");
            return result;
        }
        if (student.getClassId().intValue() == preClassId.intValue()) {
            result.setCode(-1015);
            result.setMsg("该学员已经在该班级了 还更新个锤子");
            return result;
        }
        ZjStudentClass oriClass = zjStudentClassMapper.selectByPrimaryKey(oriClassId);
        ZjStudentClass preClass = zjStudentClassMapper.selectByPrimaryKey(preClassId);
        if (Objects.isNull(oriClass) || Objects.isNull(preClass)) {
            result.setCode(-1013);
            result.setMsg("两个班级数据库中不存在");
            return result;
        }
        student.setClassId(preClassId);
        int res = zjStudentMapper.updateByPrimaryKeySelective(student);
        result.setData(res);
        return result;
    }

    @Override
    @Transactional
    public ResultDto batchInsertGrade(Integer examId) {
        List<ZjStudent> students = zjStudentMapper.selectAllStudent();
        List<ZjStudentSubject> subjects = subjectMapper.selectAllSubject();
        List<ZjStudentGrades> grades = new ArrayList<>();
        Random random = new Random();
        for (ZjStudent stu : students) {
            for (ZjStudentSubject sub : subjects) {
                Double grade = random.nextInt(10000) / 100.0;
                ZjStudentGrades zjGrade = new ZjStudentGrades();
                zjGrade.setStudentId(stu.getId());
                zjGrade.setExamId(examId);
                zjGrade.setSubjectId(sub.getId());
                zjGrade.setGrades(grade);
                grades.add(zjGrade);
            }
        }
        int res = gradesMapper.batchInsertOrUpdateGrade(grades);
        ResultDto result = new ResultDto();
        result.setData(res);
        return result;
    }
}
