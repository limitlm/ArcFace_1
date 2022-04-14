package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentBacktime;

/**
 * 归寝时间记录Mapper接口
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
public interface StudentBacktimeMapper 
{
    /**
     * 查询归寝时间记录
     * 
     * @param idcard 归寝时间记录主键
     * @return 归寝时间记录
     */
    public StudentBacktime selectStudentBacktimeByIdcard(Integer idcard);

    /**
     * 查询归寝时间记录列表
     * 
     * @param studentBacktime 归寝时间记录
     * @return 归寝时间记录集合
     */
    public List<StudentBacktime> selectStudentBacktimeList(StudentBacktime studentBacktime);

    /**
     * 新增归寝时间记录
     * 
     * @param studentBacktime 归寝时间记录
     * @return 结果
     */
    public int insertStudentBacktime(StudentBacktime studentBacktime);

    /**
     * 修改归寝时间记录
     * 
     * @param studentBacktime 归寝时间记录
     * @return 结果
     */
    public int updateStudentBacktime(StudentBacktime studentBacktime);

    /**
     * 删除归寝时间记录
     * 
     * @param idcard 归寝时间记录主键
     * @return 结果
     */
    public int deleteStudentBacktimeByIdcard(Integer idcard);

    /**
     * 批量删除归寝时间记录
     * 
     * @param idcards 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentBacktimeByIdcards(String[] idcards);
}
