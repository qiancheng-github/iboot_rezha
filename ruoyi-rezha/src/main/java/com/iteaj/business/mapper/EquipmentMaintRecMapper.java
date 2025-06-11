package com.iteaj.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iteaj.business.domain.EquipmentMaintRec;
import com.iteaj.business.vo.EquipmentMainStatsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 设备维护记录Mapper接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Mapper
public interface EquipmentMaintRecMapper extends BaseMapper<EquipmentMaintRec>
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
     * 删除设备维护记录
     * 
     * @param recordId 设备维护记录主键
     * @return 结果
     */
    public int deleteEquipmentMaintRecByRecordId(Long recordId);

    /**
     * 批量删除设备维护记录
     * 
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipmentMaintRecByRecordIds(Long[] recordIds);

    /**
     * 根据年份统计不同维护类型的次数
     * @param equipmentMaintRec
     * @return
     */
    EquipmentMainStatsVo getMaintStatsByYear(EquipmentMaintRec equipmentMaintRec);

}
