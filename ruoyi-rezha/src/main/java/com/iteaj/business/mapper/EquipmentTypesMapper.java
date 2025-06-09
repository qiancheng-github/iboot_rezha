package com.iteaj.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iteaj.business.domain.EquipmentTypes;
import com.iteaj.business.vo.EquipmentOverviewVo;

import java.util.List;

/**
 * 存储设备类型信息的，支持树状结构Mapper接口
 * 
 * @author ldkj
 * @date 2025-02-27
 */
public interface EquipmentTypesMapper extends BaseMapper<EquipmentTypes>
{
    /**
     * 查询存储设备类型信息的，支持树状结构
     * 
     * @param equipmentTypeId 存储设备类型信息的，支持树状结构主键
     * @return 存储设备类型信息的，支持树状结构
     */
    public EquipmentTypes selectEquipmentTypesByEquipmentTypeId(Long equipmentTypeId);

    /**
     * 查询存储设备类型信息的，支持树状结构列表
     * 
     * @param equipmentTypes 存储设备类型信息的，支持树状结构
     * @return 存储设备类型信息的，支持树状结构集合
     */
    public List<EquipmentTypes> selectEquipmentTypesList(EquipmentTypes equipmentTypes);

    /**
     * 新增存储设备类型信息的，支持树状结构
     * 
     * @param equipmentTypes 存储设备类型信息的，支持树状结构
     * @return 结果
     */
    public int insertEquipmentTypes(EquipmentTypes equipmentTypes);

    /**
     * 修改存储设备类型信息的，支持树状结构
     * 
     * @param equipmentTypes 存储设备类型信息的，支持树状结构
     * @return 结果
     */
    public int updateEquipmentTypes(EquipmentTypes equipmentTypes);

    /**
     * 删除存储设备类型信息的，支持树状结构
     * 
     * @param equipmentTypeId 存储设备类型信息的，支持树状结构主键
     * @return 结果
     */
    public int deleteEquipmentTypesByEquipmentTypeId(Long equipmentTypeId);

    /**
     * 批量删除存储设备类型信息的，支持树状结构
     * 
     * @param equipmentTypeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipmentTypesByEquipmentTypeIds(Long[] equipmentTypeIds);

    /**
     * 设备总览-获取设备状态数量
     * @param equipmentTypes
     * @return
     */
    EquipmentOverviewVo getEquipOverview(EquipmentTypes equipmentTypes);
}
