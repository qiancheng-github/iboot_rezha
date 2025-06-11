package com.iteaj.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iteaj.business.domain.EquipmentPred;

import java.util.List;

/**
 * 设备预测Service接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
public interface IEquipmentPredService extends IService<EquipmentPred>
{
    /**
     * 查询设备预测
     * 
     * @param id 设备预测主键
     * @return 设备预测
     */
    public EquipmentPred selectEquipmentPredById(Long id);

    /**
     * 查询设备预测列表
     * 
     * @param equipmentPred 设备预测
     * @return 设备预测集合
     */
    public List<EquipmentPred> selectEquipmentPredList(EquipmentPred equipmentPred);

    /**
     * 新增设备预测
     * 
     * @param equipmentPred 设备预测
     * @return 结果
     */
    public int insertEquipmentPred(EquipmentPred equipmentPred);

    /**
     * 修改设备预测
     * 
     * @param equipmentPred 设备预测
     * @return 结果
     */
    public int updateEquipmentPred(EquipmentPred equipmentPred);

    /**
     * 批量删除设备预测
     * 
     * @param ids 需要删除的设备预测主键集合
     * @return 结果
     */
    public int deleteEquipmentPredByIds(Long[] ids);

    /**
     * 删除设备预测信息
     * 
     * @param id 设备预测主键
     * @return 结果
     */
    public int deleteEquipmentPredById(Long id);
}
