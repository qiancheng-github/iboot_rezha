package com.iteaj.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iteaj.business.domain.MonitoringEnergy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 能源监控Mapper接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Mapper
public interface MonitoringEnergyMapper extends BaseMapper<MonitoringEnergy>
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
     * 删除能源监控
     * 
     * @param id 能源监控主键
     * @return 结果
     */
    public int deleteMonitoringEnergyById(Long id);

    /**
     * 批量删除能源监控
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMonitoringEnergyByIds(Long[] ids);

    /**
     * 根据传入的小时数，获取对应时间范围内按能源类型分组的能源监控统计数据
     *
     * @param monitoringEnergy
     * @return 对应时间范围内按能源类型分组的能源监控统计数据列表
     */
    List<MonitoringEnergy> getEnergyDataByHours(MonitoringEnergy monitoringEnergy);

    /**
     * 根据年月查询各能源类型每天的能源使用数据
     * @param monitoringEnergy
     * @return
     */
    List<MonitoringEnergy> getDailyUsageByMonth(MonitoringEnergy monitoringEnergy);

    /**
     * 根据年月能源名称获取产品各规格每天的能耗趋势原始数据
     * @param monitoringEnergy
     * @return
     */
    List<MonitoringEnergy> getTrendByEnergy(MonitoringEnergy monitoringEnergy);
}
