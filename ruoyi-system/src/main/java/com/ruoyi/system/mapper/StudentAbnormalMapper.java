package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.Echarts;
import com.ruoyi.system.domain.StudentAbnormal;

/**
 * 不归记录Mapper接口
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
public interface StudentAbnormalMapper 
{
    /**
     * 查询不归记录
     * 
     * @param num 不归记录主键
     * @return 不归记录
     */
    public StudentAbnormal selectStudentAbnormalByNum(Integer num);

    /**
     * 查询不归记录列表
     * 
     * @param studentAbnormal 不归记录
     * @return 不归记录集合
     */
    public List<StudentAbnormal> selectStudentAbnormalList(StudentAbnormal studentAbnormal);

    /**
     * 查询学生不归人数
     *
     * @return 不归情况List
     */
    List<Echarts> countAbn();

    /**
     * 新增不归记录
     * 
     * @param studentAbnormal 不归记录
     * @return 结果
     */
    public int insertStudentAbnormal(StudentAbnormal studentAbnormal);

    /**
     * 定时新增不归记录
     *
     *
     * @return 结果
     */
    public void insertAbnormal();

    /**
     * 修改不归记录
     * 
     * @param studentAbnormal 不归记录
     * @return 结果
     */
    public int updateStudentAbnormal(StudentAbnormal studentAbnormal);

    /**
     * 删除不归记录
     * 
     * @param num 不归记录主键
     * @return 结果
     */
    public int deleteStudentAbnormalByNum(Integer num);

    /**
     * 批量删除不归记录
     * 
     * @param nums 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentAbnormalByNums(String[] nums);
}
