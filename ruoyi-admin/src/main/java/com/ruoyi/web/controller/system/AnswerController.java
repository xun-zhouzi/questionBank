package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.Answer;
import com.ruoyi.system.service.IAnswerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 答案Controller
 *
 * @author ruoyi
 * @date 2024-03-22
 */
@RestController
@RequestMapping("/system/answer")
public class AnswerController extends BaseController
{
    @Autowired
    private IAnswerService answerService;

    /**
     * 查询答案列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Answer answer)
    {
        startPage();
        List<Answer> list = answerService.selectAnswerList(answer);
        return getDataTable(list);
    }

    /**
     * 导出答案列表
     */
    @PreAuthorize("@ss.hasPermi('system:answer:export')")
    @Log(title = "答案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Answer answer)
    {
        List<Answer> list = answerService.selectAnswerList(answer);
        ExcelUtil<Answer> util = new ExcelUtil<Answer>(Answer.class);
        util.exportExcel(response, list, "答案数据");
    }

    /**
     * 获取答案详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:answer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(answerService.selectAnswerById(id));
    }

    /**
     * 新增答案
     */
    @PreAuthorize("@ss.hasPermi('system:answer:add')")
    @Log(title = "答案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Answer answer)
    {
        return toAjax(answerService.insertAnswer(answer));
    }

    /**
     * 修改答案
     */
    @PreAuthorize("@ss.hasPermi('system:answer:edit')")
    @Log(title = "答案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Answer answer)
    {
        return toAjax(answerService.updateAnswer(answer));
    }

    /**
     * 删除答案
     */
    @PreAuthorize("@ss.hasPermi('system:answer:remove')")
    @Log(title = "答案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(answerService.deleteAnswerByIds(ids));
    }
}
