package com.iteaj.business.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iteaj.business.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iteaj.business.mapper.EquipmentPredMapper;
import com.iteaj.business.domain.EquipmentPred;
import com.iteaj.business.service.IEquipmentPredService;

/**
 * 设备预测Service业务层处理
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Service
public class EquipmentPredServiceImpl extends ServiceImpl<EquipmentPredMapper, EquipmentPred> implements IEquipmentPredService
{
    @Autowired
    private EquipmentPredMapper equipmentPredMapper;

    /**
     * 查询设备预测
     * 
     * @param id 设备预测主键
     * @return 设备预测
     */
    @Override
    public EquipmentPred selectEquipmentPredById(Long id)
    {
        return equipmentPredMapper.selectEquipmentPredById(id);
    }

    /**
     * 查询设备预测列表
     * 
     * @param equipmentPred 设备预测
     * @return 设备预测
     */
    @Override
    public List<EquipmentPred> selectEquipmentPredList(EquipmentPred equipmentPred)
    {
        return equipmentPredMapper.selectEquipmentPredList(equipmentPred);
    }

    /**
     * 新增设备预测
     * 
     * @param equipmentPred 设备预测
     * @return 结果
     */
    @Override
    public int insertEquipmentPred(EquipmentPred equipmentPred)
    {
        equipmentPred.setCreateTime(DateUtils.getNowDate());
        return equipmentPredMapper.insertEquipmentPred(equipmentPred);
    }

    /**
     * 修改设备预测
     * 
     * @param equipmentPred 设备预测
     * @return 结果
     */
    @Override
    public int updateEquipmentPred(EquipmentPred equipmentPred)
    {
        equipmentPred.setUpdateTime(DateUtils.getNowDate());
        return equipmentPredMapper.updateEquipmentPred(equipmentPred);
    }

    /**
     * 批量删除设备预测
     * 
     * @param ids 需要删除的设备预测主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentPredByIds(Long[] ids)
    {
        return equipmentPredMapper.deleteEquipmentPredByIds(ids);
    }

    /**
     * 删除设备预测信息
     * 
     * @param id 设备预测主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentPredById(Long id)
    {
        return equipmentPredMapper.deleteEquipmentPredById(id);
    }
}
