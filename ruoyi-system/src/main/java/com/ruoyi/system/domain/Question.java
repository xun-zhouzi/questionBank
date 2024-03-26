package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 问题对象 question
 *
 * @author ruoyi
 * @date 2024-03-22
 */
public class Question extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 问题id
     */
    private Long id;

    /**
     * 类型id
     */
    @Excel(name = "类型id")
    private Long typeid;

    /**
     * 问题
     */
    @Excel(name = "问题")
    private String question;


    /**
     * 答案
     */
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("typeid", getTypeid())
                .append("question", getQuestion())
                .append("remark", getRemark())
                .toString();
    }
}
