package com.iteaj.business.service;

import java.util.List;
import com.iteaj.business.domain.MonitoringEnv;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 监控_环境Service接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
public interface IMonitoringEnvService extends IService<MonitoringEnv>
{
    /**
     * 查询监控_环境
     * 
     * @param id 监控_环境主键
     * @return 监控_环境
     */
    public MonitoringEnv selectMonitoringEnvById(Long id);

    /**
     * 查询监控_环境列表
     * 
     * @param monitoringEnv 监控_环境
     * @return 监控_环境集合
     */
    public List<MonitoringEnv> selectMonitoringEnvList(MonitoringEnv monitoringEnv);

    /**
     * 新增监控_环境
     * 
     * @param monitoringEnv 监控_环境
     * @return 结果
     */
    public int insertMonitoringEnv(MonitoringEnv monitoringEnv);

    /**
     * 修改监控_环境
     * 
     * @param monitoringEnv 监控_环境
     * @return 结果
     */
    public int updateMonitoringEnv(MonitoringEnv monitoringEnv);

    /**
     * 批量删除监控_环境
     * 
     * @param ids 需要删除的监控_环境主键集合
     * @return 结果
     */
    public int deleteMonitoringEnvByIds(Long[] ids);

    /**
     * 删除监控_环境信息
     * 
     * @param id 监控_环境主键
     * @return 结果
     */
    public int deleteMonitoringEnvById(Long id);
}
