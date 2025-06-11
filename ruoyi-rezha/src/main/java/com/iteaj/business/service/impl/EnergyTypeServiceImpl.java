package com.iteaj.business.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iteaj.business.domain.EnergyType;
import com.iteaj.business.mapper.EnergyTypeMapper;
import com.iteaj.business.service.IEnergyTypeService;
import com.iteaj.common.utils.CommentUtil;
import com.iteaj.common.utils.DateUtils;
import com.iteaj.framework.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 能源类型Service业务层处理
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Service
public class EnergyTypeServiceImpl extends ServiceImpl<EnergyTypeMapper, EnergyType> implements IEnergyTypeService
{

    @Autowired
    private EnergyTypeMapper energyTypeMapper;

    /**
     * 查询能源类型
     *
     * @param id 能源类型主键
     * @return 能源类型
     */
    @Override
    public EnergyType selectEnergyTypeById(Long id)
    {
        return energyTypeMapper.selectEnergyTypeById(id);
    }

    /**
     * 查询能源类型列表
     *
     * @param energyType 能源类型
     * @return 能源类型
     */
    @Override
    public PageResult<IPage<EnergyType>> selectEnergyTypeList(Page page,EnergyType energyType)
    {
        //energyType.setCompanyId(103L);
        return new PageResult<>(energyTypeMapper.selectEnergyTypeList(page,energyType));
    }

    /**
     * 新增能源类型
     *
     * @param energyType 能源类型
     * @return 结果
     */
    @Override
    public int insertEnergyType(EnergyType energyType)
    {
        //设置工厂id
        CommentUtil.resetCompanyId(energyType);
        energyType.setCreateTime(DateUtils.getNowDate());
        return energyTypeMapper.insert(energyType);
    }

    /**
     * 修改能源类型
     *
     * @param energyType 能源类型
     * @return 结果
     */
    @Override
    public int updateEnergyType(EnergyType energyType)
    {
        energyType.setUpdateTime(DateUtils.getNowDate());
        return energyTypeMapper.updateEnergyType(energyType);
    }

    /**
     * 批量删除能源类型
     *
     * @param ids 需要删除的能源类型主键
     * @return 结果
     */
    @Override
    public int deleteEnergyTypeByIds(Long[] ids)
    {
        return energyTypeMapper.deleteEnergyTypeByIds(ids);
    }

    /**
     * 删除能源类型信息
     *
     * @param id 能源类型主键
     * @return 结果
     */
    @Override
    public int deleteEnergyTypeById(Long id)
    {
        return energyTypeMapper.deleteEnergyTypeById(id);
    }

}
