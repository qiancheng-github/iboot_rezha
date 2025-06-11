package com.iteaj.business.controller;

import com.iteaj.business.domain.MonitoringScrap;
import com.iteaj.business.service.IMonitoringScrapService;
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
 * 废品监控Controller
 * 
 * @author qiancheng
 * @date 2025-03-05
 */
@RestController
@RequestMapping("/business/scrap")
public class MonitoringScrapController extends BaseController
{
    @Autowired
    private IMonitoringScrapService monitoringScrapService;

    /**
     * 查询废品监控列表
     */
    
    @GetMapping("/list")
    public TableDataInfo list(MonitoringScrap monitoringScrap)
    {
        startPage();
        List<MonitoringScrap> list = monitoringScrapService.selectMonitoringScrapList(monitoringScrap);
        return getDataTable(list);
    }

    /**
     * 导出废品监控列表
     */
    
    @Log(title = "废品监控", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MonitoringScrap monitoringScrap)
    {
        List<MonitoringScrap> list = monitoringScrapService.selectMonitoringScrapList(monitoringScrap);
        ExcelUtil<MonitoringScrap> util = new ExcelUtil<MonitoringScrap>(MonitoringScrap.class);
        util.exportExcel(response, list, "废品监控数据");
    }

    /**
     * 获取废品监控详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(monitoringScrapService.selectMonitoringScrapById(id));
    }

    /**
     * 新增废品监控
     */
    
    @Log(title = "废品监控", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MonitoringScrap monitoringScrap)
    {
        return toAjax(monitoringScrapService.insertMonitoringScrap(monitoringScrap));
    }

    /**
     * 修改废品监控
     */
    
    @Log(title = "废品监控", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MonitoringScrap monitoringScrap)
    {
        return toAjax(monitoringScrapService.updateMonitoringScrap(monitoringScrap));
    }

    /**
     * 删除废品监控
     */
    
    @Log(title = "废品监控", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(monitoringScrapService.deleteMonitoringScrapByIds(ids));
    }
}
