package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentInfo;

/**
 * 学生信息Mapper接口
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
public interface StudentInfoMapper 
{
    /**
     * 查询学生信息
     * 
     * @param idcard 学生信息主键
     * @return 学生信息
     */
    public StudentInfo selectStudentInfoByIdcard(Integer idcard);

    /**
     * 查询学生信息列表
     * 
     * @param studentInfo 学生信息
     * @return 学生信息集合
     */
    public List<StudentInfo> selectStudentInfoList(StudentInfo studentInfo);

    /**
     * 新增学生信息
     * 
     * @param studentInfo 学生信息
     * @return 结果
     */
    public int insertStudentInfo(StudentInfo studentInfo);

    /**
     * 修改学生信息
     * 
     * @param studentInfo 学生信息
     * @return 结果
     */
    public int updateStudentInfo(StudentInfo studentInfo);

    /**
     * 删除学生信息
     * 
     * @param idcard 学生信息主键
     * @return 结果
     */
    public int deleteStudentInfoByIdcard(Integer idcard);

    /**
     * 批量删除学生信息
     * 
     * @param idcards 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentInfoByIdcards(String[] idcards);
}
