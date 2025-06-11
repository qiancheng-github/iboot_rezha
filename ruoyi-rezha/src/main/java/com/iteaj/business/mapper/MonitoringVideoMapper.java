package com.iteaj.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iteaj.business.domain.MonitoringVideo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 监控_视频Mapper接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Mapper
public interface MonitoringVideoMapper extends BaseMapper<MonitoringVideo>
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
     * 删除监控_视频
     * 
     * @param id 监控_视频主键
     * @return 结果
     */
    public int deleteMonitoringVideoById(Long id);

    /**
     * 批量删除监控_视频
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMonitoringVideoByIds(Long[] ids);
}
