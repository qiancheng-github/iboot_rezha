package com.iteaj.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.iteaj.business.domain.EnergyType;
import com.iteaj.framework.result.PageResult;

import java.util.List;

/**
 * 能源类型Service接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
public interface IEnergyTypeService extends IService<EnergyType>
{
    /**
     * 查询能源类型
     *
     * @param id 能源类型主键
     * @return 能源类型
     */
    public EnergyType selectEnergyTypeById(Long id);

    /**
     * 查询能源类型列表
     *
     * @param energyType 能源类型
     * @return 能源类型集合
     */
    PageResult<IPage<EnergyType>> selectEnergyTypeList(Page page,EnergyType energyType);

    /**
     * 新增能源类型
     *
     * @param energyType 能源类型
     * @return 结果
     */
    public int insertEnergyType(EnergyType energyType);

    /**
     * 修改能源类型
     *
     * @param energyType 能源类型
     * @return 结果
     */
    public int updateEnergyType(EnergyType energyType);

    /**
     * 批量删除能源类型
     *
     * @param ids 需要删除的能源类型主键集合
     * @return 结果
     */
    public int deleteEnergyTypeByIds(Long[] ids);

    /**
     * 删除能源类型信息
     *
     * @param id 能源类型主键
     * @return 结果
     */
    public int deleteEnergyTypeById(Long id);

}
