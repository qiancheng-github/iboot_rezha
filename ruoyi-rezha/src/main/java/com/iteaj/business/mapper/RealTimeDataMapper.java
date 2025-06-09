package com.iteaj.business.mapper;

import java.util.List;
import com.iteaj.business.domain.RealTimeData;

/**
 * 实时数据Mapper接口
 * 
 * @author ldkj
 * @date 2025-02-26
 */
public interface RealTimeDataMapper 
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
     * 删除实时数据
     * 
     * @param variableId 实时数据主键
     * @return 结果
     */
    public int deleteRealTimeDataByVariableId(Long variableId);

    /**
     * 批量删除实时数据
     * 
     * @param variableIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRealTimeDataByVariableIds(Long[] variableIds);
}
