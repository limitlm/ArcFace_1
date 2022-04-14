package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 归寝时间记录对象 student_backtime
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
public class StudentBacktime extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学号 */
    @Excel(name = "学号")
    private Integer idcard;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 归寝时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "归寝时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date backtime;

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
    public void setBacktime(Date backtime) 
    {
        this.backtime = backtime;
    }

    public Date getBacktime() 
    {
        return backtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("idcard", getIdcard())
            .append("name", getName())
            .append("backtime", getBacktime())
            .toString();
    }
}
