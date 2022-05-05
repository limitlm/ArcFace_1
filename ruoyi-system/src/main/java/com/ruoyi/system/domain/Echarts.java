package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class Echarts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    public Echarts(String name, int num) {
        this.name = name;
        this.num = num;
    }

    private String name;
    private int num;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
}
