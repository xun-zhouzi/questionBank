package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.Type;

/**
 * 类型Mapper接口
 *
 * @author ruoyi
 * @date 2024-03-18
 */
public interface TypeMapper
{
    /**
     * 查询类型
     *
     * @param id 类型主键
     * @return 类型
     */
    public Type selectTypeById(Long id);

    /**
     * 查询类型列表
     *
     * @param type 类型
     * @return 类型集合
     */
    public List<Type> selectTypeList(Type type);

    /**
     * 新增类型
     *
     * @param type 类型
     * @return 结果
     */
    public int insertType(Type type);

    /**
     * 修改类型
     *
     * @param type 类型
     * @return 结果
     */
    public int updateType(Type type);

    /**
     * 删除类型
     *
     * @param id 类型主键
     * @return 结果
     */
    public int deleteTypeById(Long id);

    /**
     * 批量删除类型
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTypeByIds(Long[] ids);
}
