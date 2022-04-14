package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.StudentFace;

/**
 * 人脸信息Service接口
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
public interface IStudentFaceService 
{
    /**
     * 查询人脸信息
     * 
     * @param idcard 人脸信息主键
     * @return 人脸信息
     */
    public StudentFace selectStudentFaceByIdcard(Integer idcard);

    /**
     * 查询人脸信息列表
     * 
     * @param studentFace 人脸信息
     * @return 人脸信息集合
     */
    public List<StudentFace> selectStudentFaceList(StudentFace studentFace);

    /**
     * 新增人脸信息
     * 
     * @param studentFace 人脸信息
     * @return 结果
     */
    public int insertStudentFace(StudentFace studentFace);

    /**
     * 修改人脸信息
     * 
     * @param studentFace 人脸信息
     * @return 结果
     */
    public int updateStudentFace(StudentFace studentFace);

    /**
     * 批量删除人脸信息
     * 
     * @param idcards 需要删除的人脸信息主键集合
     * @return 结果
     */
    public int deleteStudentFaceByIdcards(String idcards);

    /**
     * 删除人脸信息信息
     * 
     * @param idcard 人脸信息主键
     * @return 结果
     */
    public int deleteStudentFaceByIdcard(Integer idcard);
}
