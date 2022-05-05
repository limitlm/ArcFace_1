package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.Echarts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentAbnormalMapper;
import com.ruoyi.system.domain.StudentAbnormal;
import com.ruoyi.system.service.IStudentAbnormalService;
import com.ruoyi.common.core.text.Convert;

/**
 * 不归记录Service业务层处理
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
@Service
public class StudentAbnormalServiceImpl implements IStudentAbnormalService 
{
    @Autowired
    private StudentAbnormalMapper studentAbnormalMapper;

    /**
     * 查询不归记录
     * 
     * @param num 不归记录主键
     * @return 不归记录
     */
    @Override
    public StudentAbnormal selectStudentAbnormalByNum(Integer num)
    {
        return studentAbnormalMapper.selectStudentAbnormalByNum(num);
    }

    /**
     * 查询不归记录列表
     * 
     * @param studentAbnormal 不归记录
     * @return 不归记录
     */
    @Override
    public List<StudentAbnormal> selectStudentAbnormalList(StudentAbnormal studentAbnormal)
    {
        return studentAbnormalMapper.selectStudentAbnormalList(studentAbnormal);
    }

    @Override
    public List<Echarts> countAbn() {
        return studentAbnormalMapper.countAbn();
    }

    /**
     * 新增不归记录
     * 
     * @param studentAbnormal 不归记录
     * @return 结果
     */
    @Override
    public int insertStudentAbnormal(StudentAbnormal studentAbnormal)
    {
        return studentAbnormalMapper.insertStudentAbnormal(studentAbnormal);
    }

    /**
     * 定时新增不归记录
     *
     *
     * @return 结果
     */
    @Override
    public void insertAbnormal()
    {
        studentAbnormalMapper.insertAbnormal();
    }

    /**
     * 修改不归记录
     * 
     * @param studentAbnormal 不归记录
     * @return 结果
     */
    @Override
    public int updateStudentAbnormal(StudentAbnormal studentAbnormal)
    {
        return studentAbnormalMapper.updateStudentAbnormal(studentAbnormal);
    }

    /**
     * 批量删除不归记录
     * 
     * @param nums 需要删除的不归记录主键
     * @return 结果
     */
    @Override
    public int deleteStudentAbnormalByNums(String nums)
    {
        return studentAbnormalMapper.deleteStudentAbnormalByNums(Convert.toStrArray(nums));
    }

    /**
     * 删除不归记录信息
     * 
     * @param num 不归记录主键
     * @return 结果
     */
    @Override
    public int deleteStudentAbnormalByNum(Integer num)
    {
        return studentAbnormalMapper.deleteStudentAbnormalByNum(num);
    }
}
