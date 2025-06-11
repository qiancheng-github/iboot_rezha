package com.iteaj.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iteaj.business.domain.MonitoringVideo;

import java.util.List;

/**
 * 监控_视频Service接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
public interface IMonitoringVideoService extends IService<MonitoringVideo>
{
    /**
     * 查询监控_视频
     * 
     * @param id 监控_视频主键
     * @return 监控_视频
     */
    public MonitoringVideo selectMonitoringVideoById(Long id);

    /**
     * 查询监控_视频列表
     * 
     * @param monitoringVideo 监控_视频
     * @return 监控_视频集合
     */
    public List<MonitoringVideo> selectMonitoringVideoList(MonitoringVideo monitoringVideo);

    /**
     * 新增监控_视频
     * 
     * @param monitoringVideo 监控_视频
     * @return 结果
     */
    public int insertMonitoringVideo(MonitoringVideo monitoringVideo);

    /**
     * 修改监控_视频
     * 
     * @param monitoringVideo 监控_视频
     * @return 结果
     */
    public int updateMonitoringVideo(MonitoringVideo monitoringVideo);

    /**
     * 批量删除监控_视频
     * 
     * @param ids 需要删除的监控_视频主键集合
     * @return 结果
     */
    public int deleteMonitoringVideoByIds(Long[] ids);

    /**
     * 删除监控_视频信息
     * 
     * @param id 监控_视频主键
     * @return 结果
     */
    public int deleteMonitoringVideoById(Long id);
}
