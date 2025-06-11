package com.iteaj.business.service;

import com.iteaj.business.domain.RealTimeData;

import java.util.List;

/**
 * 实时数据Service接口
 * 
 * @author ldkj
 * @date 2025-02-26
 */
public interface IRealTimeDataService 
{
    /**
     * 查询实时数据
     * 
     * @param variableId 实时数据主键
     * @return 实时数据
     */
    public RealTimeData selectRealTimeDataByVariableId(Long variableId);

    /**
     * 查询实时数据列表
     * 
     * @param realTimeData 实时数据
     * @return 实时数据集合
     */
    public List<RealTimeData> selectRealTimeDataList(RealTimeData realTimeData);

    /**
     * 新增实时数据
     * 
     * @param realTimeData 实时数据
     * @return 结果
     */
    public int insertRealTimeData(RealTimeData realTimeData);

    /**
     * 修改实时数据
     * 
     * @param realTimeData 实时数据
     * @return 结果
     */
    public int updateRealTimeData(RealTimeData realTimeData);

    /**
     * 批量删除实时数据
     * 
     * @param variableIds 需要删除的实时数据主键集合
     * @return 结果
     */
    public int deleteRealTimeDataByVariableIds(Long[] variableIds);

    /**
     * 删除实时数据信息
     * 
     * @param variableId 实时数据主键
     * @return 结果
     */
    public int deleteRealTimeDataByVariableId(Long variableId);
}
