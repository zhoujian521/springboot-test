package com.zjpower.springboot.dao;

import com.zjpower.springboot.entity.ZjStudentGrades;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZjStudentGradesMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(ZjStudentGrades record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ZjStudentGrades record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ZjStudentGrades selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ZjStudentGrades record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ZjStudentGrades record);

    /**
     * 批量存在即更新 不存在即插入
     * @param grades
     * @return
     */
    int batchInsertOrUpdateGrade(@Param("gradesList") List<ZjStudentGrades> grades);


}