package com.zjpower.springboot.dao;

import com.zjpower.springboot.entity.ZjStudent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ZjStudentMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(ZjStudent record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ZjStudent record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    ZjStudent selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ZjStudent record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ZjStudent record);

    /**
     * 根据班级Id && 学生名称 查询学生
     *
     * @param classId
     * @param stuName
     * @return
     */
    List<ZjStudent> selectByClassIdAndStuName(@Param("classId") Integer classId, @Param("stuName") String stuName);

    /**
     * 批量插入学员
     *
     * @param students
     * @return
     */
    int batchInsertStudents(@Param("students") List<ZjStudent> students);

    /**
     * 查询所有的学生
     * @return
     */
    List<ZjStudent> selectAllStudent();
}