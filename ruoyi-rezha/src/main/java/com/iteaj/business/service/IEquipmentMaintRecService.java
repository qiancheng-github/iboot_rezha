package com.iteaj.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iteaj.business.domain.EquipmentMaintRec;
import com.iteaj.business.vo.EquipmentMainStatsVo;

import java.util.List;

/**
 * 设备维护记录Service接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
public interface IEquipmentMaintRecService extends IService<EquipmentMaintRec>
{
    /**
     * 查询设备维护记录
     * 
     * @param recordId 设备维护记录主键
     * @return 设备维护记录
     */
    public EquipmentMaintRec selectEquipmentMaintRecByRecordId(Long recordId);

    /**
     * 查询设备维护记录列表
     * 
     * @param equipmentMaintRec 设备维护记录
     * @return 设备维护记录集合
     */
    public List<EquipmentMaintRec> selectEquipmentMaintRecList(EquipmentMaintRec equipmentMaintRec);

    /**
     * 新增设备维护记录
     * 
     * @param equipmentMaintRec 设备维护记录
     * @return 结果
     */
    public int insertEquipmentMaintRec(EquipmentMaintRec equipmentMaintRec);

    /**
     * 修改设备维护记录
     * 
     * @param equipmentMaintRec 设备维护记录
     * @return 结果
     */
    public int updateEquipmentMaintRec(EquipmentMaintRec equipmentMaintRec);

    /**
     * 批量删除设备维护记录
     * 
     * @param recordIds 需要删除的设备维护记录主键集合
     * @return 结果
     */
    public int deleteEquipmentMaintRecByRecordIds(Long[] recordIds);

    /**
     * 删除设备维护记录信息
     * 
     * @param recordId 设备维护记录主键
     * @return 结果
     */
    public int deleteEquipmentMaintRecByRecordId(Long recordId);

    /**
     * 设备维护记录_查询设备维护记录列表
     * @param equipmentMaintRec
     * @return
     */
    EquipmentMainStatsVo getMaintRecListByYear(EquipmentMaintRec equipmentMaintRec);

}
