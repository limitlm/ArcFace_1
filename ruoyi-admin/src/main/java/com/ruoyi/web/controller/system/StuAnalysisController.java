package com.ruoyi.web.controller.system;

import com.google.gson.Gson;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.Echarts;
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

    @GetMapping()
    public String stuanalysis() {
        return prefix + "/stuanalysis";
    }

    /**
     * 查询echarts列表
     */
    @PostMapping("/list")
    @ResponseBody
    public String list() {
/*        List<Echarts> list = echartsService.findAll(echarts);
        List<Echarts> list = new ArrayList<>();
        Echarts echarts1 = new Echarts("在寝", 12);
        Echarts echarts2 = new Echarts("不在", 4);
        Echarts echarts3 = new Echarts("未知", 34);
        list.add(echarts1);
        list.add(echarts2);
        list.add(echarts3);*/
        List<Echarts> list = iStudentInfoService.countIsin();
        for (Echarts string : list) {
            System.out.println(string);
        }
        //转换json
        Gson gson = new Gson();
        //获取list中第一个字段name和num
//        System.err.println(list.get(0).getName() + "----" + list.get(0).getNum());
        return gson.toJson(list);
    }


}
