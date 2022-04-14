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
import com.ruoyi.system.domain.StudentBacktime;
import com.ruoyi.system.service.IStudentBacktimeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 归寝时间记录Controller
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
@Controller
@RequestMapping("/system/backtime")
public class StudentBacktimeController extends BaseController
{
    private String prefix = "system/backtime";

    @Autowired
    private IStudentBacktimeService studentBacktimeService;

    @RequiresPermissions("system:backtime:view")
    @GetMapping()
    public String backtime()
    {
        return prefix + "/backtime";
    }

    /**
     * 查询归寝时间记录列表
     */
    @RequiresPermissions("system:backtime:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentBacktime studentBacktime)
    {
        startPage();
        List<StudentBacktime> list = studentBacktimeService.selectStudentBacktimeList(studentBacktime);
        return getDataTable(list);
    }

    /**
     * 导出归寝时间记录列表
     */
    @RequiresPermissions("system:backtime:export")
    @Log(title = "归寝时间记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentBacktime studentBacktime)
    {
        List<StudentBacktime> list = studentBacktimeService.selectStudentBacktimeList(studentBacktime);
        ExcelUtil<StudentBacktime> util = new ExcelUtil<StudentBacktime>(StudentBacktime.class);
        return util.exportExcel(list, "归寝时间记录数据");
    }

    /**
     * 新增归寝时间记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存归寝时间记录
     */
    @RequiresPermissions("system:backtime:add")
    @Log(title = "归寝时间记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentBacktime studentBacktime)
    {
        return toAjax(studentBacktimeService.insertStudentBacktime(studentBacktime));
    }

    /**
     * 修改归寝时间记录
     */
    @RequiresPermissions("system:backtime:edit")
    @GetMapping("/edit/{idcard}")
    public String edit(@PathVariable("idcard") Integer idcard, ModelMap mmap)
    {
        StudentBacktime studentBacktime = studentBacktimeService.selectStudentBacktimeByIdcard(idcard);
        mmap.put("studentBacktime", studentBacktime);
        return prefix + "/edit";
    }

    /**
     * 修改保存归寝时间记录
     */
    @RequiresPermissions("system:backtime:edit")
    @Log(title = "归寝时间记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentBacktime studentBacktime)
    {
        return toAjax(studentBacktimeService.updateStudentBacktime(studentBacktime));
    }

    /**
     * 删除归寝时间记录
     */
    @RequiresPermissions("system:backtime:remove")
    @Log(title = "归寝时间记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentBacktimeService.deleteStudentBacktimeByIdcards(ids));
    }
}
