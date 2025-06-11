package com.iteaj.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iteaj.business.domain.MonitoringScrap;
import com.iteaj.business.mapper.MonitoringScrapMapper;
import com.iteaj.business.service.IMonitoringScrapService;
import com.iteaj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 废品监控Service业务层处理
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Service
public class MonitoringScrapServiceImpl extends ServiceImpl<MonitoringScrapMapper, MonitoringScrap> implements IMonitoringScrapService
{
    @Autowired
    private MonitoringScrapMapper monitoringScrapMapper;

    /**
     * 查询废品监控
     * 
     * @param id 废品监控主键
     * @return 废品监控
     */
    @Override
    public MonitoringScrap selectMonitoringScrapById(Long id)
    {
        return monitoringScrapMapper.selectMonitoringScrapById(id);
    }

    /**
     * 查询废品监控列表
     * 
     * @param monitoringScrap 废品监控
     * @return 废品监控
     */
    @Override
    public List<MonitoringScrap> selectMonitoringScrapList(MonitoringScrap monitoringScrap)
    {
        return monitoringScrapMapper.selectMonitoringScrapList(monitoringScrap);
    }

    /**
     * 新增废品监控
     * 
     * @param monitoringScrap 废品监控
     * @return 结果
     */
    @Override
    public int insertMonitoringScrap(MonitoringScrap monitoringScrap)
    {
        monitoringScrap.setCreateTime(DateUtils.getNowDate());
        return monitoringScrapMapper.insertMonitoringScrap(monitoringScrap);
    }

    /**
     * 修改废品监控
     * 
     * @param monitoringScrap 废品监控
     * @return 结果
     */
    @Override
    public int updateMonitoringScrap(MonitoringScrap monitoringScrap)
    {
        monitoringScrap.setUpdateTime(DateUtils.getNowDate());
        return monitoringScrapMapper.updateMonitoringScrap(monitoringScrap);
    }

    /**
     * 批量删除废品监控
     * 
     * @param ids 需要删除的废品监控主键
     * @return 结果
     */
    @Override
    public int deleteMonitoringScrapByIds(Long[] ids)
    {
        return monitoringScrapMapper.deleteMonitoringScrapByIds(ids);
    }

    /**
     * 删除废品监控信息
     * 
     * @param id 废品监控主键
     * @return 结果
     */
    @Override
    public int deleteMonitoringScrapById(Long id)
    {
        return monitoringScrapMapper.deleteMonitoringScrapById(id);
    }
}
