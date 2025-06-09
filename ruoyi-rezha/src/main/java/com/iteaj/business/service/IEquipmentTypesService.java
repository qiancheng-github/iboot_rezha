package com.iteaj.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iteaj.business.domain.EquipmentTypes;
import com.iteaj.business.vo.EquipPredictDetailVO;
import com.iteaj.business.vo.EquipPredictVO;
import com.iteaj.business.vo.EquipmentOverviewVo;

import java.util.List;

/**
 * 存储设备类型信息的，支持树状结构Service接口
 * 
 * @author ldkj
 * @date 2025-02-27
 */
public interface IEquipmentTypesService extends IService<EquipmentTypes>
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
     * 批量删除存储设备类型信息的，支持树状结构
     * 
     * @param equipmentTypeIds 需要删除的存储设备类型信息的，支持树状结构主键集合
     * @return 结果
     */
    public int deleteEquipmentTypesByEquipmentTypeIds(Long[] equipmentTypeIds);

    /**
     * 删除存储设备类型信息的，支持树状结构信息
     * 
     * @param equipmentTypeId 存储设备类型信息的，支持树状结构主键
     * @return 结果
     */
    public int deleteEquipmentTypesByEquipmentTypeId(Long equipmentTypeId);

    /**
     * 设备总览-获取设备状态数量
     * @param equipmentTypes
     * @return
     */
    EquipmentOverviewVo getEquipOverview(EquipmentTypes equipmentTypes);

    /**
     * 设备管理->>设备预测->>获取设备预测汇总信息
     * @param equipmentTypes
     * @return
     */
    EquipPredictVO getEquipPredict(EquipmentTypes equipmentTypes);

    /**
     * 设备管理->>设备预测->>获取设备预测信息列表
     * @param equipmentTypes
     * @return
     */
    List<EquipPredictDetailVO> getEquipPredictDetailList(EquipmentTypes equipmentTypes);
}
