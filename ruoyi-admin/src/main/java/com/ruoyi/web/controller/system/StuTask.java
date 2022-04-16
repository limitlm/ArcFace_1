package com.ruoyi.web.controller.system;

import com.ruoyi.system.service.IStudentAbnormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author 付林铭
 */
@Component("StuTask")
public class StuTask {
    @Autowired
    private IStudentAbnormalService studentAbnormalService;
    public void setAbnormal(){
        System.out.println("查找不在寝室的学生并记录为不归");
        studentAbnormalService.insertAbnormal();
    }
}
