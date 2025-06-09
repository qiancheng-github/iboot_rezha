package com.iteaj.business.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iteaj.business.domain.EquipmentPred;
import org.apache.ibatis.annotations.Mapper;

/**
 * 设备预测Mapper接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Mapper
public interface EquipmentPredMapper extends BaseMapper<EquipmentPred>
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
     * 删除设备预测
     * 
     * @param id 设备预测主键
     * @return 结果
     */
    public int deleteEquipmentPredById(Long id);

    /**
     * 批量删除设备预测
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipmentPredByIds(Long[] ids);
}
