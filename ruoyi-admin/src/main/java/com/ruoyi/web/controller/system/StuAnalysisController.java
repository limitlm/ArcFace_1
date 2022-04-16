package com.ruoyi.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system/stuanalysis")
public class StuAnalysisController {
    @GetMapping()
    public String index(){
        return "/system/stuanalysis/index";
    }
}
