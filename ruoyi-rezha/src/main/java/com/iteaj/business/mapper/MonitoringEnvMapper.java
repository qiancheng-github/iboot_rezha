package com.iteaj.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iteaj.business.domain.MonitoringEnv;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 监控_环境Mapper接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Mapper
public interface MonitoringEnvMapper extends BaseMapper<MonitoringEnv>
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
     * 删除监控_环境
     * 
     * @param id 监控_环境主键
     * @return 结果
     */
    public int deleteMonitoringEnvById(Long id);

    /**
     * 批量删除监控_环境
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMonitoringEnvByIds(Long[] ids);
}
