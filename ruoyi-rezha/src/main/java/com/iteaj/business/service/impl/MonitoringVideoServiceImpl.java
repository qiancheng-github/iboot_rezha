package com.iteaj.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iteaj.business.domain.MonitoringVideo;
import com.iteaj.business.mapper.MonitoringVideoMapper;
import com.iteaj.business.service.IMonitoringVideoService;
import com.iteaj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 监控_视频Service业务层处理
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Service
public class MonitoringVideoServiceImpl extends ServiceImpl<MonitoringVideoMapper, MonitoringVideo> implements IMonitoringVideoService
{
    @Autowired
    private MonitoringVideoMapper monitoringVideoMapper;

    /**
     * 查询监控_视频
     * 
     * @param id 监控_视频主键
     * @return 监控_视频
     */
    @Override
    public MonitoringVideo selectMonitoringVideoById(Long id)
    {
        return monitoringVideoMapper.selectMonitoringVideoById(id);
    }

    /**
     * 查询监控_视频列表
     * 
     * @param monitoringVideo 监控_视频
     * @return 监控_视频
     */
    @Override
    public List<MonitoringVideo> selectMonitoringVideoList(MonitoringVideo monitoringVideo)
    {
        return monitoringVideoMapper.selectMonitoringVideoList(monitoringVideo);
    }

    /**
     * 新增监控_视频
     * 
     * @param monitoringVideo 监控_视频
     * @return 结果
     */
    @Override
    public int insertMonitoringVideo(MonitoringVideo monitoringVideo)
    {
        monitoringVideo.setCreateTime(DateUtils.getNowDate());
        return monitoringVideoMapper.insertMonitoringVideo(monitoringVideo);
    }

    /**
     * 修改监控_视频
     * 
     * @param monitoringVideo 监控_视频
     * @return 结果
     */
    @Override
    public int updateMonitoringVideo(MonitoringVideo monitoringVideo)
    {
        monitoringVideo.setUpdateTime(DateUtils.getNowDate());
        return monitoringVideoMapper.updateMonitoringVideo(monitoringVideo);
    }

    /**
     * 批量删除监控_视频
     * 
     * @param ids 需要删除的监控_视频主键
     * @return 结果
     */
    @Override
    public int deleteMonitoringVideoByIds(Long[] ids)
    {
        return monitoringVideoMapper.deleteMonitoringVideoByIds(ids);
    }

    /**
     * 删除监控_视频信息
     * 
     * @param id 监控_视频主键
     * @return 结果
     */
    @Override
    public int deleteMonitoringVideoById(Long id)
    {
        return monitoringVideoMapper.deleteMonitoringVideoById(id);
    }
}
