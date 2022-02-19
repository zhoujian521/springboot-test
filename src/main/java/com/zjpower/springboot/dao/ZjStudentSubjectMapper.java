package com.zjpower.springboot.dao;

import com.zjpower.springboot.entity.ZjStudentSubject;

import java.util.List;

public interface ZjStudentSubjectMapper {
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
    int insert(ZjStudentSubject record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ZjStudentSubject record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ZjStudentSubject selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ZjStudentSubject record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ZjStudentSubject record);

    /**
     * 查询所有的科目
     * @return
     */
    List<ZjStudentSubject>  selectAllSubject();
}