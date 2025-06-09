package com.iteaj.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iteaj.business.mapper.RealTimeDataMapper;
import com.iteaj.business.domain.RealTimeData;
import com.iteaj.business.service.IRealTimeDataService;

/**
 * 实时数据Service业务层处理
 * 
 * @author ldkj
 * @date 2025-02-26
 */
@Service
public class RealTimeDataServiceImpl implements IRealTimeDataService 
{
    @Autowired
    private RealTimeDataMapper realTimeDataMapper;

    /**
     * 查询实时数据
     * 
     * @param variableId 实时数据主键
     * @return 实时数据
     */
    @Override
    public RealTimeData selectRealTimeDataByVariableId(Long variableId)
    {
        return realTimeDataMapper.selectRealTimeDataByVariableId(variableId);
    }

    /**
     * 查询实时数据列表
     * 
     * @param realTimeData 实时数据
     * @return 实时数据
     */
    @Override
    public List<RealTimeData> selectRealTimeDataList(RealTimeData realTimeData)
    {
        return realTimeDataMapper.selectRealTimeDataList(realTimeData);
    }

    /**
     * 新增实时数据
     * 
     * @param realTimeData 实时数据
     * @return 结果
     */
    @Override
    public int insertRealTimeData(RealTimeData realTimeData)
    {
        return realTimeDataMapper.insertRealTimeData(realTimeData);
    }

    /**
     * 修改实时数据
     * 
     * @param realTimeData 实时数据
     * @return 结果
     */
    @Override
    public int updateRealTimeData(RealTimeData realTimeData)
    {
        return realTimeDataMapper.updateRealTimeData(realTimeData);
    }

    /**
     * 批量删除实时数据
     * 
     * @param variableIds 需要删除的实时数据主键
     * @return 结果
     */
    @Override
    public int deleteRealTimeDataByVariableIds(Long[] variableIds)
    {
        return realTimeDataMapper.deleteRealTimeDataByVariableIds(variableIds);
    }

    /**
     * 删除实时数据信息
     * 
     * @param variableId 实时数据主键
     * @return 结果
     */
    @Override
    public int deleteRealTimeDataByVariableId(Long variableId)
    {
        return realTimeDataMapper.deleteRealTimeDataByVariableId(variableId);
    }
}
