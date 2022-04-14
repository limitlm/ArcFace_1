package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentFaceMapper;
import com.ruoyi.system.domain.StudentFace;
import com.ruoyi.system.service.IStudentFaceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 人脸信息Service业务层处理
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
@Service
public class StudentFaceServiceImpl implements IStudentFaceService 
{
    @Autowired
    private StudentFaceMapper studentFaceMapper;

    /**
     * 查询人脸信息
     * 
     * @param idcard 人脸信息主键
     * @return 人脸信息
     */
    @Override
    public StudentFace selectStudentFaceByIdcard(Integer idcard)
    {
        return studentFaceMapper.selectStudentFaceByIdcard(idcard);
    }

    /**
     * 查询人脸信息列表
     * 
     * @param studentFace 人脸信息
     * @return 人脸信息
     */
    @Override
    public List<StudentFace> selectStudentFaceList(StudentFace studentFace)
    {
        return studentFaceMapper.selectStudentFaceList(studentFace);
    }

    /**
     * 新增人脸信息
     * 
     * @param studentFace 人脸信息
     * @return 结果
     */
    @Override
    public int insertStudentFace(StudentFace studentFace)
    {
        studentFace.setCreateTime(DateUtils.getNowDate());
        return studentFaceMapper.insertStudentFace(studentFace);
    }

    /**
     * 修改人脸信息
     * 
     * @param studentFace 人脸信息
     * @return 结果
     */
    @Override
    public int updateStudentFace(StudentFace studentFace)
    {
        studentFace.setUpdateTime(DateUtils.getNowDate());
        return studentFaceMapper.updateStudentFace(studentFace);
    }

    /**
     * 批量删除人脸信息
     * 
     * @param idcards 需要删除的人脸信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentFaceByIdcards(String idcards)
    {
        return studentFaceMapper.deleteStudentFaceByIdcards(Convert.toStrArray(idcards));
    }

    /**
     * 删除人脸信息信息
     * 
     * @param idcard 人脸信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentFaceByIdcard(Integer idcard)
    {
        return studentFaceMapper.deleteStudentFaceByIdcard(idcard);
    }
}
