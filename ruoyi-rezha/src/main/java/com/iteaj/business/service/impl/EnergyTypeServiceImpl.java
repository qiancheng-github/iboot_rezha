package com.iteaj.business.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iteaj.business.domain.EnergyType;
import com.iteaj.business.mapper.EnergyTypeMapper;
import com.iteaj.business.service.IEnergyTypeService;
import com.iteaj.framework.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * 查询能源类型列表
     *
     * @param energyType 能源类型
     * @return 能源类型
     */
    @Override
    public PageResult<IPage<EnergyType>> selectEnergyTypeList(Page page,EnergyType energyType)
    {
       energyType.setCompanyId(103L);
        return new PageResult<>(energyTypeMapper.selectEnergyTypeList(page,energyType));
    }

}
