package com.iteaj.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iteaj.business.domain.MonitoringEquipAlarm;
import com.iteaj.business.vo.AlarmStatsVO;

import java.util.List;

/**
 * 监控_设备预警Service接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
public interface IMonitoringEquipAlarmService extends IService<MonitoringEquipAlarm>
{
    /**
     * 查询监控_设备预警
     * 
     * @param id 监控_设备预警主键
     * @return 监控_设备预警
     */
    public MonitoringEquipAlarm selectMonitoringEquipAlarmById(Long id);

    /**
     * 查询监控_设备预警列表
     * 
     * @param monitoringEquipAlarm 监控_设备预警
     * @return 监控_设备预警集合
     */
    public List<MonitoringEquipAlarm> selectMonitoringEquipAlarmList(MonitoringEquipAlarm monitoringEquipAlarm);

    /**
     * 新增监控_设备预警
     * 
     * @param monitoringEquipAlarm 监控_设备预警
     * @return 结果
     */
    public int insertMonitoringEquipAlarm(MonitoringEquipAlarm monitoringEquipAlarm);

    /**
     * 修改监控_设备预警
     * 
     * @param monitoringEquipAlarm 监控_设备预警
     * @return 结果
     */
    public int updateMonitoringEquipAlarm(MonitoringEquipAlarm monitoringEquipAlarm);

    /**
     * 批量删除监控_设备预警
     * 
     * @param ids 需要删除的监控_设备预警主键集合
     * @return 结果
     */
    public int deleteMonitoringEquipAlarmByIds(Long[] ids);

    /**
     * 删除监控_设备预警信息
     * 
     * @param id 监控_设备预警主键
     * @return 结果
     */
    public int deleteMonitoringEquipAlarmById(Long id);

    /**
     * 获取设备安全预警统计信息
     * @param monitoringEquipAlarm
     * @return AlarmStatsVO对象，包含该年份的安全预警统计信息
     */
    AlarmStatsVO getAlarmStats(MonitoringEquipAlarm monitoringEquipAlarm);
    
}
