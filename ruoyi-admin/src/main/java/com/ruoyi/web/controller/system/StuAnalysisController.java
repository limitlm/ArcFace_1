package com.ruoyi.web.controller.system;

import com.google.gson.Gson;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.Echarts;
import com.ruoyi.system.service.IStudentAbnormalService;
import com.ruoyi.system.service.IStudentBacktimeService;
import com.ruoyi.system.service.IStudentInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 付林铭
 * @date 2022-05-4
 */
@Controller
@RequestMapping("/system/stuanalysis")
public class StuAnalysisController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(StuAnalysisController.class);
    private final String prefix = "system/stuanalysis";

    @Autowired
    private IStudentInfoService iStudentInfoService;
    @Autowired
    private IStudentAbnormalService iStudentAbnormalService;
    @Autowired
    private IStudentBacktimeService iStudentBacktimeService;

    @GetMapping()
    public String stuanalysis() {
        return prefix + "/stuanalysis";
    }

    /**
     * 查询在寝情况
     */
    @PostMapping("/zqqk")
    @ResponseBody
    public String zqqk() {
        List<Echarts> list = iStudentInfoService.countIsin();
        for (Echarts string : list) {
            System.out.println(string);
        }
        //转换json
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /**
     * 查询在寝情况
     */
    @PostMapping("/bgtop")
    @ResponseBody
    public String bgtop() {
        List<Echarts> list = iStudentAbnormalService.countTop();
        for (Echarts string : list) {
            System.out.println(string);
        }
        //转换json
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /**
     * 查询晚归人数
     */
    @PostMapping("/wgqk")
    @ResponseBody
    public String wgqk() {
        List<Echarts> list = iStudentBacktimeService.countWg();
        for (Echarts string : list) {
            System.out.println(string);
        }
        //转换json
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /**
     * 查询不归人数
     */
    @PostMapping("/bgqk")
    @ResponseBody
    public String bgqk() {
        List<Echarts> list = iStudentAbnormalService.countAbn();
        for (Echarts string : list) {
            System.out.println(string);
        }
        //转换json
        Gson gson = new Gson();
        return gson.toJson(list);
    }

}
