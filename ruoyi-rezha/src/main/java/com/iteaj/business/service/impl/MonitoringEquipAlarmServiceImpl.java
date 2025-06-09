package com.iteaj.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iteaj.business.domain.MonitoringEquipAlarm;
import com.iteaj.business.mapper.MonitoringEquipAlarmMapper;
import com.iteaj.business.service.IMonitoringEquipAlarmService;
import com.iteaj.business.vo.AlarmStatsVO;
import com.iteaj.business.utils.CommentUtil;
import com.iteaj.business.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 监控_设备预警Service业务层处理
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Service
public class MonitoringEquipAlarmServiceImpl extends ServiceImpl<MonitoringEquipAlarmMapper, MonitoringEquipAlarm> implements IMonitoringEquipAlarmService
{
    @Autowired
    private MonitoringEquipAlarmMapper monitoringEquipAlarmMapper;

    /**
     * 查询监控_设备预警
     * 
     * @param id 监控_设备预警主键
     * @return 监控_设备预警
     */
    @Override
    public MonitoringEquipAlarm selectMonitoringEquipAlarmById(Long id)
    {
        return monitoringEquipAlarmMapper.selectMonitoringEquipAlarmById(id);
    }

    /**
     * 查询监控_设备预警列表
     * 
     * @param monitoringEquipAlarm 监控_设备预警
     * @return 监控_设备预警
     */
    @Override
    public List<MonitoringEquipAlarm> selectMonitoringEquipAlarmList(MonitoringEquipAlarm monitoringEquipAlarm)
    {
        return monitoringEquipAlarmMapper.selectMonitoringEquipAlarmList(monitoringEquipAlarm);
    }

    /**
     * 新增监控_设备预警
     * 
     * @param monitoringEquipAlarm 监控_设备预警
     * @return 结果
     */
    @Override
    public int insertMonitoringEquipAlarm(MonitoringEquipAlarm monitoringEquipAlarm)
    {
        monitoringEquipAlarm.setCreateTime(DateUtils.getNowDate());
        return monitoringEquipAlarmMapper.insertMonitoringEquipAlarm(monitoringEquipAlarm);
    }

    /**
     * 修改监控_设备预警
     * 
     * @param monitoringEquipAlarm 监控_设备预警
     * @return 结果
     */
    @Override
    public int updateMonitoringEquipAlarm(MonitoringEquipAlarm monitoringEquipAlarm)
    {
        monitoringEquipAlarm.setUpdateTime(DateUtils.getNowDate());
        return monitoringEquipAlarmMapper.updateMonitoringEquipAlarm(monitoringEquipAlarm);
    }

    /**
     * 批量删除监控_设备预警
     * 
     * @param ids 需要删除的监控_设备预警主键
     * @return 结果
     */
    @Override
    public int deleteMonitoringEquipAlarmByIds(Long[] ids)
    {
        return monitoringEquipAlarmMapper.deleteMonitoringEquipAlarmByIds(ids);
    }

    /**
     * 删除监控_设备预警信息
     * 
     * @param id 监控_设备预警主键
     * @return 结果
     */
    @Override
    public int deleteMonitoringEquipAlarmById(Long id)
    {
        return monitoringEquipAlarmMapper.deleteMonitoringEquipAlarmById(id);
    }

    /**
     * 获取设备安全预警统计信息
     * @param monitoringEquipAlarm
     * @return AlarmStatsVO对象，包含该年份的安全预警统计信息
     */
    @Override
    public AlarmStatsVO getAlarmStats(MonitoringEquipAlarm monitoringEquipAlarm) {
        CommentUtil.resetCompanyIdIfNull(monitoringEquipAlarm);
        return baseMapper.getAlarmStats(monitoringEquipAlarm);
    }
}
