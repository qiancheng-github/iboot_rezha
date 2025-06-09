package com.iteaj.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iteaj.business.domain.MonitoringEquipAlarm;
import com.iteaj.business.vo.AlarmStatsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 监控_设备预警Mapper接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Mapper
public interface MonitoringEquipAlarmMapper extends BaseMapper<MonitoringEquipAlarm>
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
     * 删除监控_设备预警
     * 
     * @param id 监控_设备预警主键
     * @return 结果
     */
    public int deleteMonitoringEquipAlarmById(Long id);

    /**
     * 批量删除监控_设备预警
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMonitoringEquipAlarmByIds(Long[] ids);

    /**
     * 获取设备安全预警统计信息
     * @param monitoringEquipAlarm
     * @return AlarmStatsVO对象，包含该年份的安全预警统计信息
     */
    AlarmStatsVO getAlarmStats(MonitoringEquipAlarm monitoringEquipAlarm);
}
