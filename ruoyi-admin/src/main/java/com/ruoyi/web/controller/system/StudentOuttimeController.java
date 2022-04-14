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
import com.ruoyi.system.domain.StudentOuttime;
import com.ruoyi.system.service.IStudentOuttimeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出寝时间记录Controller
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
@Controller
@RequestMapping("/system/outtime")
public class StudentOuttimeController extends BaseController
{
    private String prefix = "system/outtime";

    @Autowired
    private IStudentOuttimeService studentOuttimeService;

    @RequiresPermissions("system:outtime:view")
    @GetMapping()
    public String outtime()
    {
        return prefix + "/outtime";
    }

    /**
     * 查询出寝时间记录列表
     */
    @RequiresPermissions("system:outtime:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentOuttime studentOuttime)
    {
        startPage();
        List<StudentOuttime> list = studentOuttimeService.selectStudentOuttimeList(studentOuttime);
        return getDataTable(list);
    }

    /**
     * 导出出寝时间记录列表
     */
    @RequiresPermissions("system:outtime:export")
    @Log(title = "出寝时间记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentOuttime studentOuttime)
    {
        List<StudentOuttime> list = studentOuttimeService.selectStudentOuttimeList(studentOuttime);
        ExcelUtil<StudentOuttime> util = new ExcelUtil<StudentOuttime>(StudentOuttime.class);
        return util.exportExcel(list, "出寝时间记录数据");
    }

    /**
     * 新增出寝时间记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存出寝时间记录
     */
    @RequiresPermissions("system:outtime:add")
    @Log(title = "出寝时间记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentOuttime studentOuttime)
    {
        return toAjax(studentOuttimeService.insertStudentOuttime(studentOuttime));
    }

    /**
     * 修改出寝时间记录
     */
    @RequiresPermissions("system:outtime:edit")
    @GetMapping("/edit/{idcard}")
    public String edit(@PathVariable("idcard") Integer idcard, ModelMap mmap)
    {
        StudentOuttime studentOuttime = studentOuttimeService.selectStudentOuttimeByIdcard(idcard);
        mmap.put("studentOuttime", studentOuttime);
        return prefix + "/edit";
    }

    /**
     * 修改保存出寝时间记录
     */
    @RequiresPermissions("system:outtime:edit")
    @Log(title = "出寝时间记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentOuttime studentOuttime)
    {
        return toAjax(studentOuttimeService.updateStudentOuttime(studentOuttime));
    }

    /**
     * 删除出寝时间记录
     */
    @RequiresPermissions("system:outtime:remove")
    @Log(title = "出寝时间记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentOuttimeService.deleteStudentOuttimeByIdcards(ids));
    }
}
