package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 答案对象 answer
 * 
 * @author ruoyi
 * @date 2024-03-22
 */
public class Answer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 答案id */
    private Long id;

    /** 问题id */
    @Excel(name = "问题id")
    private Long questionId;

    /** 答案 */
    @Excel(name = "答案")
    private String answer;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setQuestionId(Long questionId) 
    {
        this.questionId = questionId;
    }

    public Long getQuestionId() 
    {
        return questionId;
    }
    public void setAnswer(String answer) 
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("questionId", getQuestionId())
            .append("answer", getAnswer())
            .append("remark", getRemark())
            .toString();
    }
}
