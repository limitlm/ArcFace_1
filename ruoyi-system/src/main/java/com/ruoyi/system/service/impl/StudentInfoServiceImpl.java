package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.Echarts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentInfoMapper;
import com.ruoyi.system.domain.StudentInfo;
import com.ruoyi.system.service.IStudentInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生信息Service业务层处理
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
@Service
public class StudentInfoServiceImpl implements IStudentInfoService 
{
    @Autowired
    private StudentInfoMapper studentInfoMapper;

    /**
     * 查询学生信息
     * 
     * @param idcard 学生信息主键
     * @return 学生信息
     */
    @Override
    public StudentInfo selectStudentInfoByIdcard(Integer idcard)
    {
        return studentInfoMapper.selectStudentInfoByIdcard(idcard);
    }

    /**
     * 查询学生信息列表
     * 
     * @param studentInfo 学生信息
     * @return 学生信息
     */
    @Override
    public List<StudentInfo> selectStudentInfoList(StudentInfo studentInfo)
    {
        return studentInfoMapper.selectStudentInfoList(studentInfo);
    }

    @Override
    public List<Echarts> countIsin() {
        return studentInfoMapper.countIsin();
    }

    /**
     * 新增学生信息
     * 
     * @param studentInfo 学生信息
     * @return 结果
     */
    @Override
    public int insertStudentInfo(StudentInfo studentInfo)
    {
        return studentInfoMapper.insertStudentInfo(studentInfo);
    }

    /**
     * 修改学生信息
     * 
     * @param studentInfo 学生信息
     * @return 结果
     */
    @Override
    public int updateStudentInfo(StudentInfo studentInfo)
    {
        return studentInfoMapper.updateStudentInfo(studentInfo);
    }

    /**
     * 批量删除学生信息
     * 
     * @param idcards 需要删除的学生信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentInfoByIdcards(String idcards)
    {
        return studentInfoMapper.deleteStudentInfoByIdcards(Convert.toStrArray(idcards));
    }

    /**
     * 删除学生信息信息
     * 
     * @param idcard 学生信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentInfoByIdcard(Integer idcard)
    {
        return studentInfoMapper.deleteStudentInfoByIdcard(idcard);
    }
}
