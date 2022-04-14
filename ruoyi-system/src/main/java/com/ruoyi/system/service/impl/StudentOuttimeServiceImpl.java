package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentOuttimeMapper;
import com.ruoyi.system.domain.StudentOuttime;
import com.ruoyi.system.service.IStudentOuttimeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 出寝时间记录Service业务层处理
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
@Service
public class StudentOuttimeServiceImpl implements IStudentOuttimeService 
{
    @Autowired
    private StudentOuttimeMapper studentOuttimeMapper;

    /**
     * 查询出寝时间记录
     * 
     * @param idcard 出寝时间记录主键
     * @return 出寝时间记录
     */
    @Override
    public StudentOuttime selectStudentOuttimeByIdcard(Integer idcard)
    {
        return studentOuttimeMapper.selectStudentOuttimeByIdcard(idcard);
    }

    /**
     * 查询出寝时间记录列表
     * 
     * @param studentOuttime 出寝时间记录
     * @return 出寝时间记录
     */
    @Override
    public List<StudentOuttime> selectStudentOuttimeList(StudentOuttime studentOuttime)
    {
        return studentOuttimeMapper.selectStudentOuttimeList(studentOuttime);
    }

    /**
     * 新增出寝时间记录
     * 
     * @param studentOuttime 出寝时间记录
     * @return 结果
     */
    @Override
    public int insertStudentOuttime(StudentOuttime studentOuttime)
    {
        return studentOuttimeMapper.insertStudentOuttime(studentOuttime);
    }

    /**
     * 修改出寝时间记录
     * 
     * @param studentOuttime 出寝时间记录
     * @return 结果
     */
    @Override
    public int updateStudentOuttime(StudentOuttime studentOuttime)
    {
        return studentOuttimeMapper.updateStudentOuttime(studentOuttime);
    }

    /**
     * 批量删除出寝时间记录
     * 
     * @param idcards 需要删除的出寝时间记录主键
     * @return 结果
     */
    @Override
    public int deleteStudentOuttimeByIdcards(String idcards)
    {
        return studentOuttimeMapper.deleteStudentOuttimeByIdcards(Convert.toStrArray(idcards));
    }

    /**
     * 删除出寝时间记录信息
     * 
     * @param idcard 出寝时间记录主键
     * @return 结果
     */
    @Override
    public int deleteStudentOuttimeByIdcard(Integer idcard)
    {
        return studentOuttimeMapper.deleteStudentOuttimeByIdcard(idcard);
    }
}
