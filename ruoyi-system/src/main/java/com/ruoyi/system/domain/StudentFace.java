package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人脸信息对象 student_face
 * 
 * @author 付林铭
 * @date 2022-04-16
 */
public class StudentFace extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学号 */
    @Excel(name = "学号")
    private Integer idcard;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 人脸id */
    @Excel(name = "人脸id")
    private String faceId;

    /** 人脸特征 */
    @Excel(name = "人脸特征")
    private String faceFeature;

    public void setIdcard(Integer idcard) 
    {
        this.idcard = idcard;
    }

    public Integer getIdcard() 
    {
        return idcard;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setFaceId(String faceId) 
    {
        this.faceId = faceId;
    }

    public String getFaceId() 
    {
        return faceId;
    }
    public void setFaceFeature(String faceFeature) 
    {
        this.faceFeature = faceFeature;
    }

    public String getFaceFeature() 
    {
        return faceFeature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("idcard", getIdcard())
            .append("name", getName())
            .append("faceId", getFaceId())
            .append("faceFeature", getFaceFeature())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
