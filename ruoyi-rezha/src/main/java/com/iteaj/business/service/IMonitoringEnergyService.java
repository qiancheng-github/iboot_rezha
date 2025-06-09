package com.iteaj.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iteaj.business.domain.MonitoringEnergy;
import com.iteaj.business.vo.MultiLineChartDataVo;

import java.util.List;

/**
 * 能源监控Service接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
public interface IMonitoringEnergyService extends IService<MonitoringEnergy>
{
    /**
     * 查询能源监控
     * 
     * @param id 能源监控主键
     * @return 能源监控
     */
    public MonitoringEnergy selectMonitoringEnergyById(Long id);

    /**
     * 查询能源监控列表
     * 
     * @param monitoringEnergy 能源监控
     * @return 能源监控集合
     */
    public List<MonitoringEnergy> selectMonitoringEnergyList(MonitoringEnergy monitoringEnergy);

    /**
     * 新增能源监控
     * 
     * @param monitoringEnergy 能源监控
     * @return 结果
     */
    public int insertMonitoringEnergy(MonitoringEnergy monitoringEnergy);

    /**
     * 修改能源监控
     * 
     * @param monitoringEnergy 能源监控
     * @return 结果
     */
    public int updateMonitoringEnergy(MonitoringEnergy monitoringEnergy);

    /**
     * 批量删除能源监控
     * 
     * @param ids 需要删除的能源监控主键集合
     * @return 结果
     */
    public int deleteMonitoringEnergyByIds(Long[] ids);

    /**
     * 删除能源监控信息
     * 
     * @param id 能源监控主键
     * @return 结果
     */
    public int deleteMonitoringEnergyById(Long id);

    /**
     * 根据传入的小时数，获取对应时间范围内按能源类型分组的能源监控统计数据
     * @param monitoringEnergy
     * @return 对应时间范围内按能源类型分组的能源监控统计数据列表
     */
    List<MonitoringEnergy> getEnergyDataByHours(MonitoringEnergy monitoringEnergy);

    /**
     * 根据年月查询各能源类型每天的能源使用数据
     * @param monitoringEnergy
     * @return
     */
    MultiLineChartDataVo getDailyUsageByMonth(MonitoringEnergy monitoringEnergy);

    /**
     * 根据年月能源名称获取产品各规格每天的能耗趋势原始数据
     * @param monitoringEnergy
     * @return
     */
    MultiLineChartDataVo getTrendByEnergy(MonitoringEnergy monitoringEnergy);
}
