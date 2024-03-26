package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.Type;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.service.ITypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 类型Controller
 *
 * @author ruoyi
 * @date 2024-03-18
 */
@RestController
@RequestMapping("/system/type")
public class TypeController extends BaseController
{
    @Autowired
    private ITypeService typeService;

    /**
     * 查询类型列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Type type)
    {
        startPage();
        List<Type> list = typeService.selectTypeList(type);
        return getDataTable(list);
    }

    /**
     * 导出类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:type:export')")
    @Log(title = "类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Type type)
    {
        List<Type> list = typeService.selectTypeList(type);
        ExcelUtil<Type> util = new ExcelUtil<Type>(Type.class);
        util.exportExcel(response, list, "类型数据");
    }

    /**
     * 获取类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(typeService.selectTypeById(id));
    }

    /**
     * 新增类型
     */
    @PreAuthorize("@ss.hasPermi('system:type:add')")
    @Log(title = "类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Type type)
    {
        return toAjax(typeService.insertType(type));
    }

    /**
     * 修改类型
     */
    @PreAuthorize("@ss.hasPermi('system:type:edit')")
    @Log(title = "类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Type type)
    {
        return toAjax(typeService.updateType(type));
    }

    /**
     * 删除类型
     */
    @PreAuthorize("@ss.hasPermi('system:type:remove')")
    @Log(title = "类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(typeService.deleteTypeByIds(ids));
    }
}
