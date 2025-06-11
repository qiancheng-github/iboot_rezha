package com.iteaj.business.service.impl;

import com.iteaj.business.domain.HistoricalData;
import com.iteaj.business.mapper.HistoricalDataMapper;
import com.iteaj.business.service.IHistoricalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 历史数据Service业务层处理
 * 
 * @author ldkj
 * @date 2025-02-26
 */
@Service
public class HistoricalDataServiceImpl implements IHistoricalDataService 
{
    @Autowired
    private HistoricalDataMapper historicalDataMapper;

    /**
     * 查询历史数据
     * 
     * @param dataId 历史数据主键
     * @return 历史数据
     */
    @Override
    public HistoricalData selectHistoricalDataByDataId(Long dataId)
    {
        return historicalDataMapper.selectHistoricalDataByDataId(dataId);
    }

    /**
     * 查询历史数据列表
     * 
     * @param historicalData 历史数据
     * @return 历史数据
     */
    @Override
    public List<HistoricalData> selectHistoricalDataList(HistoricalData historicalData)
    {
        return historicalDataMapper.selectHistoricalDataList(historicalData);
    }

    /**
     * 新增历史数据
     * 
     * @param historicalData 历史数据
     * @return 结果
     */
    @Override
    public int insertHistoricalData(HistoricalData historicalData)
    {
        return historicalDataMapper.insertHistoricalData(historicalData);
    }

    /**
     * 修改历史数据
     * 
     * @param historicalData 历史数据
     * @return 结果
     */
    @Override
    public int updateHistoricalData(HistoricalData historicalData)
    {
        return historicalDataMapper.updateHistoricalData(historicalData);
    }

    /**
     * 批量删除历史数据
     * 
     * @param dataIds 需要删除的历史数据主键
     * @return 结果
     */
    @Override
    public int deleteHistoricalDataByDataIds(Long[] dataIds)
    {
        return historicalDataMapper.deleteHistoricalDataByDataIds(dataIds);
    }

    /**
     * 删除历史数据信息
     * 
     * @param dataId 历史数据主键
     * @return 结果
     */
    @Override
    public int deleteHistoricalDataByDataId(Long dataId)
    {
        return historicalDataMapper.deleteHistoricalDataByDataId(dataId);
    }
}
