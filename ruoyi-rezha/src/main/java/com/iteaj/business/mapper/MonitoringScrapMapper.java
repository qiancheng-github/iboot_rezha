package com.iteaj.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iteaj.business.domain.MonitoringScrap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 废品监控Mapper接口
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Mapper
public interface MonitoringScrapMapper extends BaseMapper<MonitoringScrap>
{
    /**
     * 查询废品监控
     * @param id 废品监控主键
     * @return 废品监控
     */
    public MonitoringScrap selectMonitoringScrapById(@Param("id") Long id);

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
     * 删除废品监控
     * 
     * @param id 废品监控主键
     * @return 结果
     */
    public int deleteMonitoringScrapById(Long id);

    /**
     * 批量删除废品监控
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMonitoringScrapByIds(Long[] ids);
}
