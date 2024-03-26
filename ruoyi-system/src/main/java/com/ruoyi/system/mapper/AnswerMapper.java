package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Answer;

/**
 * 答案Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-22
 */
public interface AnswerMapper 
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
     * 删除答案
     * 
     * @param id 答案主键
     * @return 结果
     */
    public int deleteAnswerById(Long id);

    /**
     * 批量删除答案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAnswerByIds(Long[] ids);
}
