package com.iteaj.business.service;

import com.iteaj.business.domain.EquipmentVariables;
import com.iteaj.business.vo.StripTemMonitorVO;

import java.util.List;

/**
 * 存储设备变量参数信息的Service接口
 * 
 * @author ldkj
 * @date 2025-02-27
 */
public interface IEquipmentVariablesService 
{
    /**
     * 查询存储设备变量参数信息的
     * 
     * @param variableId 存储设备变量参数信息的主键
     * @return 存储设备变量参数信息的
     */
    public EquipmentVariables selectEquipmentVariablesByVariableId(Long variableId);

    /**
     * 查询存储设备变量参数信息的列表
     * 
     * @param equipmentVariables 存储设备变量参数信息的
     * @return 存储设备变量参数信息的集合
     */
    public List<EquipmentVariables> selectEquipmentVariablesList(EquipmentVariables equipmentVariables);

    /**
     * 新增存储设备变量参数信息的
     * 
     * @param equipmentVariables 存储设备变量参数信息的
     * @return 结果
     */
    public int insertEquipmentVariables(EquipmentVariables equipmentVariables);

    /**
     * 修改存储设备变量参数信息的
     * 
     * @param equipmentVariables 存储设备变量参数信息的
     * @return 结果
     */
    public int updateEquipmentVariables(EquipmentVariables equipmentVariables);

    /**
     * 批量删除存储设备变量参数信息的
     * 
     * @param variableIds 需要删除的存储设备变量参数信息的主键集合
     * @return 结果
     */
    public int deleteEquipmentVariablesByVariableIds(Long[] variableIds);

    /**
     * 删除存储设备变量参数信息的信息
     * 
     * @param variableId 存储设备变量参数信息的主键
     * @return 结果
     */
    public int deleteEquipmentVariablesByVariableId(Long variableId);

    /**
     * 生产管理->>带钢温度监控->>获取电磁感应入口温度
     * @param equipmentVariables
     * @return
     */
    public StripTemMonitorVO getStrpTempVo(EquipmentVariables equipmentVariables);

    /**
     * 生产管理->>激光扫描->>获取激光扫描结果
     * @param equipmentVariables
     * @return
     */
    public List<String> getLaserScanResult(EquipmentVariables equipmentVariables);

}
