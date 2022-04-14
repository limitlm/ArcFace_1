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
import com.ruoyi.system.domain.StudentInfo;
import com.ruoyi.system.service.IStudentInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生信息Controller
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
@Controller
@RequestMapping("/system/stuinfo")
public class StudentInfoController extends BaseController
{
    private String prefix = "system/stuinfo";

    @Autowired
    private IStudentInfoService studentInfoService;

    @RequiresPermissions("system:stuinfo:view")
    @GetMapping()
    public String stuinfo()
    {
        return prefix + "/stuinfo";
    }

    /**
     * 查询学生信息列表
     */
    @RequiresPermissions("system:stuinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentInfo studentInfo)
    {
        startPage();
        List<StudentInfo> list = studentInfoService.selectStudentInfoList(studentInfo);
        return getDataTable(list);
    }

    /**
     * 导出学生信息列表
     */
    @RequiresPermissions("system:stuinfo:export")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentInfo studentInfo)
    {
        List<StudentInfo> list = studentInfoService.selectStudentInfoList(studentInfo);
        ExcelUtil<StudentInfo> util = new ExcelUtil<StudentInfo>(StudentInfo.class);
        return util.exportExcel(list, "学生信息数据");
    }

    /**
     * 新增学生信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生信息
     */
    @RequiresPermissions("system:stuinfo:add")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentInfo studentInfo)
    {
        return toAjax(studentInfoService.insertStudentInfo(studentInfo));
    }

    /**
     * 修改学生信息
     */
    @RequiresPermissions("system:stuinfo:edit")
    @GetMapping("/edit/{idcard}")
    public String edit(@PathVariable("idcard") Integer idcard, ModelMap mmap)
    {
        StudentInfo studentInfo = studentInfoService.selectStudentInfoByIdcard(idcard);
        mmap.put("studentInfo", studentInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生信息
     */
    @RequiresPermissions("system:stuinfo:edit")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentInfo studentInfo)
    {
        return toAjax(studentInfoService.updateStudentInfo(studentInfo));
    }

    /**
     * 删除学生信息
     */
    @RequiresPermissions("system:stuinfo:remove")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentInfoService.deleteStudentInfoByIdcards(ids));
    }
}
