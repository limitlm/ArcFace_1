package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentOuttime;

/**
 * 出寝时间记录Mapper接口
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
public interface StudentOuttimeMapper 
{
    /**
     * 查询出寝时间记录
     * 
     * @param idcard 出寝时间记录主键
     * @return 出寝时间记录
     */
    public StudentOuttime selectStudentOuttimeByIdcard(Integer idcard);

    /**
     * 查询出寝时间记录列表
     * 
     * @param studentOuttime 出寝时间记录
     * @return 出寝时间记录集合
     */
    public List<StudentOuttime> selectStudentOuttimeList(StudentOuttime studentOuttime);

    /**
     * 新增出寝时间记录
     * 
     * @param studentOuttime 出寝时间记录
     * @return 结果
     */
    public int insertStudentOuttime(StudentOuttime studentOuttime);

    /**
     * 修改出寝时间记录
     * 
     * @param studentOuttime 出寝时间记录
     * @return 结果
     */
    public int updateStudentOuttime(StudentOuttime studentOuttime);

    /**
     * 删除出寝时间记录
     * 
     * @param idcard 出寝时间记录主键
     * @return 结果
     */
    public int deleteStudentOuttimeByIdcard(Integer idcard);

    /**
     * 批量删除出寝时间记录
     * 
     * @param idcards 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentOuttimeByIdcards(String[] idcards);
}
