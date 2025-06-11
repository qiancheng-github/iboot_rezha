package com.iteaj.business.service;

import com.iteaj.business.domain.HistoricalData;

import java.util.List;

/**
 * 历史数据Service接口
 * 
 * @author ldkj
 * @date 2025-02-26
 */
public interface IHistoricalDataService 
{
    /**
     * 查询历史数据
     * 
     * @param dataId 历史数据主键
     * @return 历史数据
     */
    public HistoricalData selectHistoricalDataByDataId(Long dataId);

    /**
     * 查询历史数据列表
     * 
     * @param historicalData 历史数据
     * @return 历史数据集合
     */
    public List<HistoricalData> selectHistoricalDataList(HistoricalData historicalData);

    /**
     * 新增历史数据
     * 
     * @param historicalData 历史数据
     * @return 结果
     */
    public int insertHistoricalData(HistoricalData historicalData);

    /**
     * 修改历史数据
     * 
     * @param historicalData 历史数据
     * @return 结果
     */
    public int updateHistoricalData(HistoricalData historicalData);

    /**
     * 批量删除历史数据
     * 
     * @param dataIds 需要删除的历史数据主键集合
     * @return 结果
     */
    public int deleteHistoricalDataByDataIds(Long[] dataIds);

    /**
     * 删除历史数据信息
     * 
     * @param dataId 历史数据主键
     * @return 结果
     */
    public int deleteHistoricalDataByDataId(Long dataId);
}
