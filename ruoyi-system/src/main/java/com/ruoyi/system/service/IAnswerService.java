package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Answer;

/**
 * 答案Service接口
 * 
 * @author ruoyi
 * @date 2024-03-22
 */
public interface IAnswerService 
{
    /**
     * 查询答案
     * 
     * @param id 答案主键
     * @return 答案
     */
    public Answer selectAnswerById(Long id);

    /**
     * 查询答案列表
     * 
     * @param answer 答案
     * @return 答案集合
     */
    public List<Answer> selectAnswerList(Answer answer);

    /**
     * 新增答案
     * 
     * @param answer 答案
     * @return 结果
     */
    public int insertAnswer(Answer answer);

    /**
     * 修改答案
     * 
     * @param answer 答案
     * @return 结果
     */
    public int updateAnswer(Answer answer);

    /**
     * 批量删除答案
     * 
     * @param ids 需要删除的答案主键集合
     * @return 结果
     */
    public int deleteAnswerByIds(Long[] ids);

    /**
     * 删除答案信息
     * 
     * @param id 答案主键
     * @return 结果
     */
    public int deleteAnswerById(Long id);
}
