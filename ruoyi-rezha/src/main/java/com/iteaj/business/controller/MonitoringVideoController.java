package com.iteaj.business.controller;

import com.iteaj.business.domain.MonitoringVideo;
import com.iteaj.business.service.IMonitoringVideoService;
import com.iteaj.common.annotation.Anonymous;
import com.iteaj.common.annotation.Log;
import com.iteaj.common.core.controller.BaseController;
import com.iteaj.common.core.domain.AjaxResult;
import com.iteaj.common.core.page.TableDataInfo;
import com.iteaj.common.enums.BusinessType;
import com.iteaj.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 监控_视频Controller
 * 
 * @author qiancheng
 * @date 2025-03-05
 */
@RestController
@RequestMapping("/business/video")
public class MonitoringVideoController extends BaseController
{
    @Autowired
    private IMonitoringVideoService monitoringVideoService;

    /**
     * 查询监控_视频列表
     */
    @Anonymous
    @GetMapping("/list")
    public AjaxResult list(MonitoringVideo monitoringVideo)
    {
        startPage();
        List<MonitoringVideo> list = monitoringVideoService.selectMonitoringVideoList(monitoringVideo);
        return success(list);
    }

    /**
     * 导出监控_视频列表
     */
    
    @Log(title = "监控_视频", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MonitoringVideo monitoringVideo)
    {
        List<MonitoringVideo> list = monitoringVideoService.selectMonitoringVideoList(monitoringVideo);
        ExcelUtil<MonitoringVideo> util = new ExcelUtil<MonitoringVideo>(MonitoringVideo.class);
        util.exportExcel(response, list, "监控_视频数据");
    }

    /**
     * 获取监控_视频详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(monitoringVideoService.selectMonitoringVideoById(id));
    }

    /**
     * 新增监控_视频
     */
    
    @Log(title = "监控_视频", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MonitoringVideo monitoringVideo)
    {
        return toAjax(monitoringVideoService.insertMonitoringVideo(monitoringVideo));
    }

    /**
     * 修改监控_视频
     */
    
    @Log(title = "监控_视频", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MonitoringVideo monitoringVideo)
    {
        return toAjax(monitoringVideoService.updateMonitoringVideo(monitoringVideo));
    }

    /**
     * 删除监控_视频
     */
    
    @Log(title = "监控_视频", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(monitoringVideoService.deleteMonitoringVideoByIds(ids));
    }
}
