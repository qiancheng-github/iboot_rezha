package com.iteaj.business.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iteaj.business.annotation.Log;
import com.iteaj.business.core.controller.BaseController;
import com.iteaj.business.core.domain.AjaxResult;
import com.iteaj.business.enums.BusinessType;
import com.iteaj.business.domain.MonitoringScrap;
import com.iteaj.business.service.IMonitoringScrapService;
import com.iteaj.business.utils.poi.ExcelUtil;
import com.iteaj.business.core.page.TableDataInfo;

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
    //@PreAuthorize("@ss.hasPermi('business:scrap:list')")
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
    //@PreAuthorize("@ss.hasPermi('business:scrap:export')")
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
    //@PreAuthorize("@ss.hasPermi('business:scrap:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(monitoringScrapService.selectMonitoringScrapById(id));
    }

    /**
     * 新增废品监控
     */
    //@PreAuthorize("@ss.hasPermi('business:scrap:add')")
    @Log(title = "废品监控", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MonitoringScrap monitoringScrap)
    {
        return toAjax(monitoringScrapService.insertMonitoringScrap(monitoringScrap));
    }

    /**
     * 修改废品监控
     */
    //@PreAuthorize("@ss.hasPermi('business:scrap:edit')")
    @Log(title = "废品监控", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MonitoringScrap monitoringScrap)
    {
        return toAjax(monitoringScrapService.updateMonitoringScrap(monitoringScrap));
    }

    /**
     * 删除废品监控
     */
    //@PreAuthorize("@ss.hasPermi('business:scrap:remove')")
    @Log(title = "废品监控", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(monitoringScrapService.deleteMonitoringScrapByIds(ids));
    }
}
