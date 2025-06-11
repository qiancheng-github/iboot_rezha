package com.iteaj.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iteaj.business.domain.MonitoringEnv;
import com.iteaj.business.mapper.MonitoringEnvMapper;
import com.iteaj.business.service.IMonitoringEnvService;
import com.iteaj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 监控_环境Service业务层处理
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Service
public class MonitoringEnvServiceImpl extends ServiceImpl<MonitoringEnvMapper, MonitoringEnv> implements IMonitoringEnvService
{
    @Autowired
    private MonitoringEnvMapper monitoringEnvMapper;

    /**
     * 查询监控_环境
     * 
     * @param id 监控_环境主键
     * @return 监控_环境
     */
    @Override
    public MonitoringEnv selectMonitoringEnvById(Long id)
    {
        return monitoringEnvMapper.selectMonitoringEnvById(id);
    }

    /**
     * 查询监控_环境列表
     * 
     * @param monitoringEnv 监控_环境
     * @return 监控_环境
     */
    @Override
    public List<MonitoringEnv> selectMonitoringEnvList(MonitoringEnv monitoringEnv)
    {
        return monitoringEnvMapper.selectMonitoringEnvList(monitoringEnv);
    }

    /**
     * 新增监控_环境
     * 
     * @param monitoringEnv 监控_环境
     * @return 结果
     */
    @Override
    public int insertMonitoringEnv(MonitoringEnv monitoringEnv)
    {
        monitoringEnv.setCreateTime(DateUtils.getNowDate());
        return monitoringEnvMapper.insertMonitoringEnv(monitoringEnv);
    }

    /**
     * 修改监控_环境
     * 
     * @param monitoringEnv 监控_环境
     * @return 结果
     */
    @Override
    public int updateMonitoringEnv(MonitoringEnv monitoringEnv)
    {
        monitoringEnv.setUpdateTime(DateUtils.getNowDate());
        return monitoringEnvMapper.updateMonitoringEnv(monitoringEnv);
    }

    /**
     * 批量删除监控_环境
     * 
     * @param ids 需要删除的监控_环境主键
     * @return 结果
     */
    @Override
    public int deleteMonitoringEnvByIds(Long[] ids)
    {
        return monitoringEnvMapper.deleteMonitoringEnvByIds(ids);
    }

    /**
     * 删除监控_环境信息
     * 
     * @param id 监控_环境主键
     * @return 结果
     */
    @Override
    public int deleteMonitoringEnvById(Long id)
    {
        return monitoringEnvMapper.deleteMonitoringEnvById(id);
    }
}
