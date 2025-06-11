package com.iteaj.business.mapper;

import com.iteaj.business.domain.EquipmentVariables;

import java.util.List;

/**
 * 存储设备变量参数信息的Mapper接口
 * 
 * @author ldkj
 * @date 2025-02-27
 */
public interface EquipmentVariablesMapper 
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
     * 删除存储设备变量参数信息的
     * 
     * @param variableId 存储设备变量参数信息的主键
     * @return 结果
     */
    public int deleteEquipmentVariablesByVariableId(Long variableId);

    /**
     * 批量删除存储设备变量参数信息的
     * 
     * @param variableIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipmentVariablesByVariableIds(Long[] variableIds);

    /**
     * 生产管理->>带钢温度监控->>获取电磁感应入口温度
     * @param equipmentVariables
     * @return
     */
    public List<EquipmentVariables> getStrpTempVo(EquipmentVariables equipmentVariables);
}
