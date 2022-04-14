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
import com.ruoyi.system.domain.StudentFace;
import com.ruoyi.system.service.IStudentFaceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人脸信息Controller
 * 
 * @author 付林铭
 * @date 2022-04-15
 */
@Controller
@RequestMapping("/system/stuface")
public class StudentFaceController extends BaseController
{
    private String prefix = "system/stuface";

    @Autowired
    private IStudentFaceService studentFaceService;

    @RequiresPermissions("system:stuface:view")
    @GetMapping()
    public String stuface()
    {
        return prefix + "/stuface";
    }

    /**
     * 查询人脸信息列表
     */
    @RequiresPermissions("system:stuface:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentFace studentFace)
    {
        startPage();
        List<StudentFace> list = studentFaceService.selectStudentFaceList(studentFace);
        return getDataTable(list);
    }

    /**
     * 导出人脸信息列表
     */
    @RequiresPermissions("system:stuface:export")
    @Log(title = "人脸信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentFace studentFace)
    {
        List<StudentFace> list = studentFaceService.selectStudentFaceList(studentFace);
        ExcelUtil<StudentFace> util = new ExcelUtil<StudentFace>(StudentFace.class);
        return util.exportExcel(list, "人脸信息数据");
    }

    /**
     * 新增人脸信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人脸信息
     */
    @RequiresPermissions("system:stuface:add")
    @Log(title = "人脸信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentFace studentFace)
    {
        return toAjax(studentFaceService.insertStudentFace(studentFace));
    }

    /**
     * 修改人脸信息
     */
    @RequiresPermissions("system:stuface:edit")
    @GetMapping("/edit/{idcard}")
    public String edit(@PathVariable("idcard") Integer idcard, ModelMap mmap)
    {
        StudentFace studentFace = studentFaceService.selectStudentFaceByIdcard(idcard);
        mmap.put("studentFace", studentFace);
        return prefix + "/edit";
    }

    /**
     * 修改保存人脸信息
     */
    @RequiresPermissions("system:stuface:edit")
    @Log(title = "人脸信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentFace studentFace)
    {
        return toAjax(studentFaceService.updateStudentFace(studentFace));
    }

    /**
     * 删除人脸信息
     */
    @RequiresPermissions("system:stuface:remove")
    @Log(title = "人脸信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentFaceService.deleteStudentFaceByIdcards(ids));
    }
}
