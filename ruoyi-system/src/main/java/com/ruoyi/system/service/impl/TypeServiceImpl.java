package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TypeMapper;
import com.ruoyi.system.service.ITypeService;

/**
 * 类型Service业务层处理
 *
 * @author ruoyi
 * @date 2024-03-18
 */
@Service
public class TypeServiceImpl implements ITypeService
{
    @Autowired
    private TypeMapper typeMapper;

    /**
     * 查询类型
     *
     * @param id 类型主键
     * @return 类型
     */
    @Override
    public Type selectTypeById(Long id)
    {
        return typeMapper.selectTypeById(id);
    }

    /**
     * 查询类型列表
     *
     * @param type 类型
     * @return 类型
     */
    @Override
    public List<Type> selectTypeList(Type type)
    {
        return typeMapper.selectTypeList(type);
    }

    /**
     * 新增类型
     *
     * @param type 类型
     * @return 结果
     */
    @Override
    public int insertType(Type type)
    {
        return typeMapper.insertType(type);
    }

    /**
     * 修改类型
     *
     * @param type 类型
     * @return 结果
     */
    @Override
    public int updateType(Type type)
    {
        return typeMapper.updateType(type);
    }

    /**
     * 批量删除类型
     *
     * @param ids 需要删除的类型主键
     * @return 结果
     */
    @Override
    public int deleteTypeByIds(Long[] ids)
    {
        return typeMapper.deleteTypeByIds(ids);
    }

    /**
     * 删除类型信息
     *
     * @param id 类型主键
     * @return 结果
     */
    @Override
    public int deleteTypeById(Long id)
    {
        return typeMapper.deleteTypeById(id);
    }
}
