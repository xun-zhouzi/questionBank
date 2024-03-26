package com.ruoyi.web.controller.system;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.Answer;
import com.ruoyi.system.domain.QA;
import com.ruoyi.system.service.IAnswerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
import com.ruoyi.system.domain.Question;
import com.ruoyi.system.service.IQuestionService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 问题Controller
 *
 * @author ruoyi
 * @date 2024-03-22
 */
@RestController
@RequestMapping("/system/question")
public class QuestionController extends BaseController {
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IAnswerService answerService;

    /**
     * 查询问题列表
     */
    @GetMapping("/list")
    public AjaxResult list(Question question) {

        //查询问题列表
        List<Question> list = questionService.selectQuestionList(question);

        //创建一个集合架子
        List<QA> objects = new ArrayList<>();

        //循环集合里的所有问题
        for (int i = 0; i < list.size(); i++) {
            //创建所有问题答案的实体类对象
            QA qa = new QA();
            //得到每一个问题
            Question questions = list.get(i);
            //把问题放在创建实体类
            qa.setQuestion(questions.getQuestion());

            qa.setId(questions.getId());

            //创建答案（查询的参数）
            Answer answer = new Answer();
            //把问题的主键放在答案的参数中
            answer.setQuestionId(questions.getId());
            //查询答案
            List<Answer> answers = answerService.selectAnswerList(answer);
            //把答案放到实体类里
            qa.setAnswer(answers.get(0).getAnswer());

            objects.add(qa);
        }

        return AjaxResult.success(objects);
    }

    /**
     * 导出问题列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:export')")
    @Log(title = "问题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Question question) {
        List<Question> list = questionService.selectQuestionList(question);
        ExcelUtil<Question> util = new ExcelUtil<Question>(Question.class);
        util.exportExcel(response, list, "问题数据");
    }

    /**
     * 获取问题详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:question:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(questionService.selectQuestionById(id));
    }

    /**
     * 新增问题
     */
    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult add(@RequestBody Question question) {

        questionService.insertQuestion(question);

        Answer answer = new Answer();
        answer.setQuestionId(question.getId());

        answer.setAnswer(question.getAnswer());
        answerService.insertAnswer(answer);
        return success();
    }

    /**
     * 修改问题
     */
    @PutMapping
    public AjaxResult edit(@RequestBody Question question) {
        return toAjax(questionService.updateQuestion(question));
    }

    /**
     * 删除问题
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {

        for (Long id : ids) {
            Answer answer = answerService.selectAnswerById(id);
            answerService.deleteAnswerById(answer.getId());
        }

        return toAjax(questionService.deleteQuestionByIds(ids));
    }
}
