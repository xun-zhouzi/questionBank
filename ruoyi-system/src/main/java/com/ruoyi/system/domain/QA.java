package com.ruoyi.system.domain;

/**
 * @author zhouzx
 * @version 1.0
 * @date 2024/3/22
 */
public class QA {

    private Long id;
    //问题
    private String question;
    //答案
    private String answer;


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
