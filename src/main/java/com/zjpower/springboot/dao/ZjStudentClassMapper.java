package com.zjpower.springboot.dao;

import com.zjpower.springboot.entity.ZjStudentClass;
import org.apache.ibatis.annotations.Param;

public interface ZjStudentClassMapper {
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
    int insert(ZjStudentClass record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ZjStudentClass record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ZjStudentClass selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ZjStudentClass record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ZjStudentClass record);

    /**
     * 根据班级名称查询班级信息
     * @param name
     * @return
     */
    ZjStudentClass selectByClassName(@Param("className") String name);
}