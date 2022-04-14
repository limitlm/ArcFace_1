package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生信息对象 student_info
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
public class StudentInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学号 */
    @Excel(name = "学号")
    private Integer idcard;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 年级 */
    @Excel(name = "年级")
    private String grade;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 班级 */
    @Excel(name = "班级")
    private String stucla;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 照片路径 */
    @Excel(name = "照片路径")
    private String fpath;

    /** 在寝状态 */
    @Excel(name = "在寝状态")
    private String isin;

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
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }
    public void setStucla(String stucla) 
    {
        this.stucla = stucla;
    }

    public String getStucla() 
    {
        return stucla;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setFpath(String fpath) 
    {
        this.fpath = fpath;
    }

    public String getFpath() 
    {
        return fpath;
    }
    public void setIsin(String isin) 
    {
        this.isin = isin;
    }

    public String getIsin() 
    {
        return isin;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("idcard", getIdcard())
            .append("name", getName())
            .append("gender", getGender())
            .append("grade", getGrade())
            .append("major", getMajor())
            .append("stucla", getStucla())
            .append("phone", getPhone())
            .append("fpath", getFpath())
            .append("isin", getIsin())
            .toString();
    }
}
