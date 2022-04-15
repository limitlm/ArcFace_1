package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 不归记录对象 student_abnormal
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
public class StudentAbnormal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Integer num;

    /** 学号 */
    @Excel(name = "学号")
    private Integer idcard;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

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

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date abntime;

    public void setNum(Integer num) 
    {
        this.num = num;
    }

    public Integer getNum() 
    {
        return num;
    }
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
    public void setAbntime(Date abntime) 
    {
        this.abntime = abntime;
    }

    public Date getAbntime() 
    {
        return abntime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("num", getNum())
            .append("idcard", getIdcard())
            .append("name", getName())
            .append("grade", getGrade())
            .append("major", getMajor())
            .append("stucla", getStucla())
            .append("phone", getPhone())
            .append("abntime", getAbntime())
            .toString();
    }
}
