package com.zjpower.springboot.dao;

import com.zjpower.springboot.entity.ZjStudentGrades;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据考试Id 查询 参加考试的学生数 班级数
     * @param examId
     * @return
     */
    Map<String, Integer> selectCountsOfTakingExamStuAndClassByExamId(Integer examId);

    /**
     * 根据考试Id 查询 全校各科的平均成绩
     * @param examId
     * @return
     */
    Map<String, Double> selectAvgGradesOfSchoolByExamId(Integer examId);

    /**
     * 根据考试Id 查询 各班级各科的平均成绩
     * @param examId
     * @return
     */
    List<Map<String, Object>> selectAvgClassGradesOfSchoolByExamId(Integer examId);

    /**
     * 根据考试Id 查询 各科的班级排名
     * @param examId
     * @return
     */
    List<Map<String, Object>> selectClassRankOfSubjectByExamId(Integer examId);

    /**
     * 根据考试Id 查询 全校考试前三名学生 总成绩 各科成绩
     * @param examId
     * @return
     */
    List<Map<String, Object>> selectTop3StuGradesByExamId(Integer examId);

    /**
     * 根据考试Id 查询 各班各科大于平均成绩的人数
     * @param examId
     * @return
     */
    List<Map<String, Integer>> selectCountGreaterAvgByExamId(Integer examId);
}