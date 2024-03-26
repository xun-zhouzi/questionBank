package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AnswerMapper;
import com.ruoyi.system.domain.Answer;
import com.ruoyi.system.service.IAnswerService;

/**
 * 答案Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-22
 */
@Service
public class AnswerServiceImpl implements IAnswerService 
{
    @Autowired
    private AnswerMapper answerMapper;

    /**
     * 查询答案
     * 
     * @param id 答案主键
     * @return 答案
     */
    @Override
    public Answer selectAnswerById(Long id)
    {
        return answerMapper.selectAnswerById(id);
    }

    /**
     * 查询答案列表
     * 
     * @param answer 答案
     * @return 答案
     */
    @Override
    public List<Answer> selectAnswerList(Answer answer)
    {
        return answerMapper.selectAnswerList(answer);
    }

    /**
     * 新增答案
     * 
     * @param answer 答案
     * @return 结果
     */
    @Override
    public int insertAnswer(Answer answer)
    {
        return answerMapper.insertAnswer(answer);
    }

    /**
     * 修改答案
     * 
     * @param answer 答案
     * @return 结果
     */
    @Override
    public int updateAnswer(Answer answer)
    {
        return answerMapper.updateAnswer(answer);
    }

    /**
     * 批量删除答案
     * 
     * @param ids 需要删除的答案主键
     * @return 结果
     */
    @Override
    public int deleteAnswerByIds(Long[] ids)
    {
        return answerMapper.deleteAnswerByIds(ids);
    }

    /**
     * 删除答案信息
     * 
     * @param id 答案主键
     * @return 结果
     */
    @Override
    public int deleteAnswerById(Long id)
    {
        return answerMapper.deleteAnswerById(id);
    }
}
