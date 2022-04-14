package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentBacktimeMapper;
import com.ruoyi.system.domain.StudentBacktime;
import com.ruoyi.system.service.IStudentBacktimeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 归寝时间记录Service业务层处理
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
@Service
public class StudentBacktimeServiceImpl implements IStudentBacktimeService 
{
    @Autowired
    private StudentBacktimeMapper studentBacktimeMapper;

    /**
     * 查询归寝时间记录
     * 
     * @param idcard 归寝时间记录主键
     * @return 归寝时间记录
     */
    @Override
    public StudentBacktime selectStudentBacktimeByIdcard(Integer idcard)
    {
        return studentBacktimeMapper.selectStudentBacktimeByIdcard(idcard);
    }

    /**
     * 查询归寝时间记录列表
     * 
     * @param studentBacktime 归寝时间记录
     * @return 归寝时间记录
     */
    @Override
    public List<StudentBacktime> selectStudentBacktimeList(StudentBacktime studentBacktime)
    {
        return studentBacktimeMapper.selectStudentBacktimeList(studentBacktime);
    }

    /**
     * 新增归寝时间记录
     * 
     * @param studentBacktime 归寝时间记录
     * @return 结果
     */
    @Override
    public int insertStudentBacktime(StudentBacktime studentBacktime)
    {
        return studentBacktimeMapper.insertStudentBacktime(studentBacktime);
    }

    /**
     * 修改归寝时间记录
     * 
     * @param studentBacktime 归寝时间记录
     * @return 结果
     */
    @Override
    public int updateStudentBacktime(StudentBacktime studentBacktime)
    {
        return studentBacktimeMapper.updateStudentBacktime(studentBacktime);
    }

    /**
     * 批量删除归寝时间记录
     * 
     * @param idcards 需要删除的归寝时间记录主键
     * @return 结果
     */
    @Override
    public int deleteStudentBacktimeByIdcards(String idcards)
    {
        return studentBacktimeMapper.deleteStudentBacktimeByIdcards(Convert.toStrArray(idcards));
    }

    /**
     * 删除归寝时间记录信息
     * 
     * @param idcard 归寝时间记录主键
     * @return 结果
     */
    @Override
    public int deleteStudentBacktimeByIdcard(Integer idcard)
    {
        return studentBacktimeMapper.deleteStudentBacktimeByIdcard(idcard);
    }
}
