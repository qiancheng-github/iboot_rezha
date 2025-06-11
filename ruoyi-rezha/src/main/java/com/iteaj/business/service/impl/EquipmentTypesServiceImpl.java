package com.iteaj.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iteaj.business.domain.EquipmentTypes;
import com.iteaj.business.mapper.EquipmentTypesMapper;
import com.iteaj.business.service.IEquipmentTypesService;
import com.iteaj.business.vo.EquipPredictDetailVO;
import com.iteaj.business.vo.EquipPredictVO;
import com.iteaj.business.vo.EquipmentOverviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储设备类型信息的，支持树状结构Service业务层处理
 * 
 * @author ldkj
 * @date 2025-02-27
 */
@Service
public class EquipmentTypesServiceImpl extends ServiceImpl<EquipmentTypesMapper, EquipmentTypes>  implements IEquipmentTypesService
{
    @Autowired
    private EquipmentTypesMapper equipmentTypesMapper;

    /**
     * 查询存储设备类型信息的，支持树状结构
     * 
     * @param equipmentTypeId 存储设备类型信息的，支持树状结构主键
     * @return 存储设备类型信息的，支持树状结构
     */
    @Override
    public EquipmentTypes selectEquipmentTypesByEquipmentTypeId(Long equipmentTypeId)
    {
        return equipmentTypesMapper.selectEquipmentTypesByEquipmentTypeId(equipmentTypeId);
    }

    /**
     * 查询存储设备类型信息的，支持树状结构列表
     * 
     * @param equipmentTypes 存储设备类型信息的，支持树状结构
     * @return 存储设备类型信息的，支持树状结构
     */
    @Override
    public List<EquipmentTypes> selectEquipmentTypesList(EquipmentTypes equipmentTypes)
    {
        return equipmentTypesMapper.selectEquipmentTypesList(equipmentTypes);
    }

    /**
     * 新增存储设备类型信息的，支持树状结构
     * 
     * @param equipmentTypes 存储设备类型信息的，支持树状结构
     * @return 结果
     */
    @Override
    public int insertEquipmentTypes(EquipmentTypes equipmentTypes)
    {
        return equipmentTypesMapper.insertEquipmentTypes(equipmentTypes);
    }

    /**
     * 修改存储设备类型信息的，支持树状结构
     * 
     * @param equipmentTypes 存储设备类型信息的，支持树状结构
     * @return 结果
     */
    @Override
    public int updateEquipmentTypes(EquipmentTypes equipmentTypes)
    {
        return equipmentTypesMapper.updateEquipmentTypes(equipmentTypes);
    }

    /**
     * 批量删除存储设备类型信息的，支持树状结构
     * 
     * @param equipmentTypeIds 需要删除的存储设备类型信息的，支持树状结构主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentTypesByEquipmentTypeIds(Long[] equipmentTypeIds)
    {
        return equipmentTypesMapper.deleteEquipmentTypesByEquipmentTypeIds(equipmentTypeIds);
    }

    /**
     * 删除存储设备类型信息的，支持树状结构信息
     * 
     * @param equipmentTypeId 存储设备类型信息的，支持树状结构主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentTypesByEquipmentTypeId(Long equipmentTypeId)
    {
        return equipmentTypesMapper.deleteEquipmentTypesByEquipmentTypeId(equipmentTypeId);
    }

    /**
     * 设备总览-获取设备状态数量
     * @param equipmentTypes
     * @return
     */
    @Override
    public EquipmentOverviewVo getEquipOverview(EquipmentTypes equipmentTypes) {
        return baseMapper.getEquipOverview(equipmentTypes);
    }

    /**
     * 设备管理->>设备预测->>获取设备预测汇总信息
     * @param equipmentTypes
     * @return
     */
    @Override
    public EquipPredictVO getEquipPredict(EquipmentTypes equipmentTypes) {
        EquipPredictVO vo = new EquipPredictVO();
        // 这里应从数据库或业务逻辑获取真实数据，以下为示例
        vo.setChangeCount(17);
        vo.setAbnormalCount(43);
        vo.setFaultRate(0.23);
        return vo;
    }

    /**
     * 设备管理->>设备预测->>获取设备预测信息列表
     * @param equipmentTypes
     * @return
     */
    @Override
    public List<EquipPredictDetailVO> getEquipPredictDetailList(EquipmentTypes equipmentTypes) {
        List<EquipPredictDetailVO> list = new ArrayList<>();
        // 示例数据，实际应从数据库查询
        EquipPredictDetailVO d1 = new EquipPredictDetailVO();
        d1.setName("粗轧机");
        d1.setUseTime("2024-08-14 08:44:35");
        d1.setRiskLevel("轻微");
        list.add(d1);

        EquipPredictDetailVO d2 = new EquipPredictDetailVO();
        d2.setName("粗轧机");
        d2.setUseTime("2024-08-14 08:44:35");
        d2.setRiskLevel("严重");
        list.add(d2);
        return list;
    }


}
