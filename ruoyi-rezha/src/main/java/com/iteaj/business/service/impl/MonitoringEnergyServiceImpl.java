package com.iteaj.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iteaj.business.domain.MonitoringEnergy;
import com.iteaj.business.mapper.MonitoringEnergyMapper;
import com.iteaj.business.service.IMonitoringEnergyService;
import com.iteaj.business.vo.MultiLineChartDataVo;
import com.iteaj.business.vo.SeriesDataVo;
import com.iteaj.common.utils.CommentUtil;
import com.iteaj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 能源监控Service业务层处理
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Service
public class MonitoringEnergyServiceImpl extends ServiceImpl<MonitoringEnergyMapper, MonitoringEnergy> implements IMonitoringEnergyService
{
    @Autowired
    private MonitoringEnergyMapper monitoringEnergyMapper;

    /**
     * 查询能源监控
     * 
     * @param id 能源监控主键
     * @return 能源监控
     */
    @Override
    public MonitoringEnergy selectMonitoringEnergyById(Long id)
    {
        return monitoringEnergyMapper.selectMonitoringEnergyById(id);
    }

    /**
     * 查询能源监控列表
     * 
     * @param monitoringEnergy 能源监控
     * @return 能源监控
     */
    @Override
    public List<MonitoringEnergy> selectMonitoringEnergyList(MonitoringEnergy monitoringEnergy)
    {
        return monitoringEnergyMapper.selectMonitoringEnergyList(monitoringEnergy);
    }

    /**
     * 新增能源监控
     * 
     * @param monitoringEnergy 能源监控
     * @return 结果
     */
    @Override
    public int insertMonitoringEnergy(MonitoringEnergy monitoringEnergy)
    {
        monitoringEnergy.setCreateTime(DateUtils.getNowDate());
        return monitoringEnergyMapper.insertMonitoringEnergy(monitoringEnergy);
    }

    /**
     * 修改能源监控
     * 
     * @param monitoringEnergy 能源监控
     * @return 结果
     */
    @Override
    public int updateMonitoringEnergy(MonitoringEnergy monitoringEnergy)
    {
        monitoringEnergy.setUpdateTime(DateUtils.getNowDate());
        return monitoringEnergyMapper.updateMonitoringEnergy(monitoringEnergy);
    }

    /**
     * 批量删除能源监控
     * 
     * @param ids 需要删除的能源监控主键
     * @return 结果
     */
    @Override
    public int deleteMonitoringEnergyByIds(Long[] ids)
    {
        return monitoringEnergyMapper.deleteMonitoringEnergyByIds(ids);
    }

    /**
     * 删除能源监控信息
     * 
     * @param id 能源监控主键
     * @return 结果
     */
    @Override
    public int deleteMonitoringEnergyById(Long id)
    {
        return monitoringEnergyMapper.deleteMonitoringEnergyById(id);
    }

    /**
     * 根据传入的小时数，获取对应时间范围内按能源类型分组的能源监控统计数据
     *
     * @param monitoringEnergy
     * @return 对应时间范围内按能源类型分组的能源监控统计数据列表
     */
    @Override
    public List<MonitoringEnergy> getEnergyDataByHours(MonitoringEnergy monitoringEnergy) {
        CommentUtil.resetCompanyIdIfNull(monitoringEnergy);
        return baseMapper.getEnergyDataByHours(monitoringEnergy);
    }

    /**
     * 根据年月查询各能源类型每天的能源使用数据
     * @param monitoringEnergy
     * @return
     */
    @Override
    public MultiLineChartDataVo getDailyUsageByMonth(MonitoringEnergy monitoringEnergy) {
        CommentUtil.resetCompanyIdIfNull(monitoringEnergy);
        List<MonitoringEnergy> resultList = monitoringEnergyMapper.getDailyUsageByMonth(monitoringEnergy);
        // 提取所有日期并排序
        List<Long> xAxis = resultList.stream()
                .map(MonitoringEnergy::getRecordDay)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        // 按能源名称分组并处理数据
        List<SeriesDataVo> yAxis = resultList.stream()
                .collect(Collectors.groupingBy(MonitoringEnergy::getEnergyName))
                .entrySet().stream()
                .map(entry -> {
                    String energyName = entry.getKey();
                    List<MonitoringEnergy> dailyUsages = entry.getValue();
                    ArrayList<Double> data = new ArrayList<>(Collections.nCopies(xAxis.size(), 0.0));
                    dailyUsages.forEach(usage -> {
                        int index = xAxis.indexOf(usage.getRecordDay());
                        if (index != -1) {
                            data.set(index, usage.getEnergyUsage() != null ? usage.getEnergyUsage().doubleValue() : 0.0);
                        }
                    });
                    SeriesDataVo seriesData = new SeriesDataVo();
                    seriesData.setName(energyName);
                    seriesData.setData(data);
                    return seriesData;
                })
                .collect(Collectors.toList());

        MultiLineChartDataVo multiLineChartData = new MultiLineChartDataVo();
        multiLineChartData.setXAxis(xAxis);
        multiLineChartData.setYAxis(yAxis);
        return multiLineChartData;
    }

    /**
     * 根据年月能源名称获取产品各规格每天的能耗趋势原始数据
     * @param monitoringEnergy
     * @return
     */
    @Override
    public MultiLineChartDataVo getTrendByEnergy(MonitoringEnergy monitoringEnergy) {
        CommentUtil.resetCompanyIdIfNull(monitoringEnergy);
        List<MonitoringEnergy> resultList = monitoringEnergyMapper.getTrendByEnergy(monitoringEnergy);
        // 提取所有日期并排序
        List<Long> xAxis = resultList.stream()
                .map(MonitoringEnergy::getRecordDay)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        // 按规格分组并处理数据
        List<SeriesDataVo> yAxis = resultList.stream()
                .collect(Collectors.groupingBy(MonitoringEnergy::getSteelSpec))
                .entrySet().stream()
                .map(entry -> {
                    String steelSpec = entry.getKey();
                    List<MonitoringEnergy> dailyUsages = entry.getValue();
                    ArrayList<Double> data = new ArrayList<>(Collections.nCopies(xAxis.size(), 0.0));
                    dailyUsages.forEach(usage -> {
                        int index = xAxis.indexOf(usage.getRecordDay());
                        if (index != -1) {
                            data.set(index, usage.getEnergyUsage() != null ? usage.getEnergyUsage().doubleValue() : 0.0);
                        }
                    });
                    SeriesDataVo seriesData = new SeriesDataVo();
                    seriesData.setName(steelSpec);
                    seriesData.setData(data);
                    return seriesData;
                })
                .collect(Collectors.toList());

        MultiLineChartDataVo multiLineChartData = new MultiLineChartDataVo();
        multiLineChartData.setXAxis(xAxis);
        multiLineChartData.setYAxis(yAxis);
        return multiLineChartData;
    }

}
