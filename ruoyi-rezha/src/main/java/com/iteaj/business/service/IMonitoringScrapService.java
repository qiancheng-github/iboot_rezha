package com.iteaj.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iteaj.business.domain.MonitoringScrap;

import java.util.List;

/**
 * 废品监控Service接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
public interface IMonitoringScrapService extends IService<MonitoringScrap>
{
    /**
     * 查询废品监控
     * 
     * @param id 废品监控主键
     * @return 废品监控
     */
    public MonitoringScrap selectMonitoringScrapById(Long id);

    /**
     * 查询废品监控列表
     * 
     * @param monitoringScrap 废品监控
     * @return 废品监控集合
     */
    public List<MonitoringScrap> selectMonitoringScrapList(MonitoringScrap monitoringScrap);

    /**
     * 新增废品监控
     * 
     * @param monitoringScrap 废品监控
     * @return 结果
     */
    public int insertMonitoringScrap(MonitoringScrap monitoringScrap);

    /**
     * 修改废品监控
     * 
     * @param monitoringScrap 废品监控
     * @return 结果
     */
    public int updateMonitoringScrap(MonitoringScrap monitoringScrap);

    /**
     * 批量删除废品监控
     * 
     * @param ids 需要删除的废品监控主键集合
     * @return 结果
     */
    public int deleteMonitoringScrapByIds(Long[] ids);

    /**
     * 删除废品监控信息
     * 
     * @param id 废品监控主键
     * @return 结果
     */
    public int deleteMonitoringScrapById(Long id);
}
