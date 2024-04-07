package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CommentMapper;
import com.ruoyi.system.domain.Comment;
import com.ruoyi.system.service.ICommentService;

/**
 * 评论内容Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-01
 */
@Service
public class CommentServiceImpl implements ICommentService 
{
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 查询评论内容
     * 
     * @param id 评论内容主键
     * @return 评论内容
     */
    @Override
    public Comment selectCommentById(Long id)
    {
        return commentMapper.selectCommentById(id);
    }

    /**
     * 查询评论内容列表
     * 
     * @param comment 评论内容
     * @return 评论内容
     */
    @Override
    public List<Comment> selectCommentList(Comment comment)
    {
        return commentMapper.selectCommentList(comment);
    }

    /**
     * 新增评论内容
     * 
     * @param comment 评论内容
     * @return 结果
     */
    @Override
    public int insertComment(Comment comment)
    {
        return commentMapper.insertComment(comment);
    }

    /**
     * 修改评论内容
     * 
     * @param comment 评论内容
     * @return 结果
     */
    @Override
    public int updateComment(Comment comment)
    {
        return commentMapper.updateComment(comment);
    }

    /**
     * 批量删除评论内容
     * 
     * @param ids 需要删除的评论内容主键
     * @return 结果
     */
    @Override
    public int deleteCommentByIds(Long[] ids)
    {
        return commentMapper.deleteCommentByIds(ids);
    }

    /**
     * 删除评论内容信息
     * 
     * @param id 评论内容主键
     * @return 结果
     */
    @Override
    public int deleteCommentById(Long id)
    {
        return commentMapper.deleteCommentById(id);
    }
}
