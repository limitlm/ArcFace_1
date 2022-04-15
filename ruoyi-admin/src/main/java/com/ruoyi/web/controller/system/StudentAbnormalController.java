package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.StudentAbnormal;
import com.ruoyi.system.service.IStudentAbnormalService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 不归记录Controller
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
@Controller
@RequestMapping("/system/stuabnormal")
public class StudentAbnormalController extends BaseController
{
    private String prefix = "system/stuabnormal";

    @Autowired
    private IStudentAbnormalService studentAbnormalService;

    @RequiresPermissions("system:stuabnormal:view")
    @GetMapping()
    public String stuabnormal()
    {
        return prefix + "/stuabnormal";
    }

    /**
     * 查询不归记录列表
     */
    @RequiresPermissions("system:stuabnormal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentAbnormal studentAbnormal)
    {
        startPage();
        List<StudentAbnormal> list = studentAbnormalService.selectStudentAbnormalList(studentAbnormal);
        return getDataTable(list);
    }

    /**
     * 导出不归记录列表
     */
    @RequiresPermissions("system:stuabnormal:export")
    @Log(title = "不归记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentAbnormal studentAbnormal)
    {
        List<StudentAbnormal> list = studentAbnormalService.selectStudentAbnormalList(studentAbnormal);
        ExcelUtil<StudentAbnormal> util = new ExcelUtil<StudentAbnormal>(StudentAbnormal.class);
        return util.exportExcel(list, "不归记录数据");
    }

    /**
     * 新增不归记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存不归记录
     */
    @RequiresPermissions("system:stuabnormal:add")
    @Log(title = "不归记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentAbnormal studentAbnormal)
    {
        return toAjax(studentAbnormalService.insertStudentAbnormal(studentAbnormal));
    }

    /**
     * 修改不归记录
     */
    @RequiresPermissions("system:stuabnormal:edit")
    @GetMapping("/edit/{num}")
    public String edit(@PathVariable("num") Integer num, ModelMap mmap)
    {
        StudentAbnormal studentAbnormal = studentAbnormalService.selectStudentAbnormalByNum(num);
        mmap.put("studentAbnormal", studentAbnormal);
        return prefix + "/edit";
    }

    /**
     * 修改保存不归记录
     */
    @RequiresPermissions("system:stuabnormal:edit")
    @Log(title = "不归记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentAbnormal studentAbnormal)
    {
        return toAjax(studentAbnormalService.updateStudentAbnormal(studentAbnormal));
    }

    /**
     * 删除不归记录
     */
    @RequiresPermissions("system:stuabnormal:remove")
    @Log(title = "不归记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentAbnormalService.deleteStudentAbnormalByNums(ids));
    }
}
