package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Comment;

/**
 * 评论内容Service接口
 * 
 * @author ruoyi
 * @date 2024-04-01
 */
public interface ICommentService 
{
    /**
     * 查询评论内容
     * 
     * @param id 评论内容主键
     * @return 评论内容
     */
    public Comment selectCommentById(Long id);

    /**
     * 查询评论内容列表
     * 
     * @param comment 评论内容
     * @return 评论内容集合
     */
    public List<Comment> selectCommentList(Comment comment);

    /**
     * 新增评论内容
     * 
     * @param comment 评论内容
     * @return 结果
     */
    public int insertComment(Comment comment);

    /**
     * 修改评论内容
     * 
     * @param comment 评论内容
     * @return 结果
     */
    public int updateComment(Comment comment);

    /**
     * 批量删除评论内容
     * 
     * @param ids 需要删除的评论内容主键集合
     * @return 结果
     */
    public int deleteCommentByIds(Long[] ids);

    /**
     * 删除评论内容信息
     * 
     * @param id 评论内容主键
     * @return 结果
     */
    public int deleteCommentById(Long id);
}
