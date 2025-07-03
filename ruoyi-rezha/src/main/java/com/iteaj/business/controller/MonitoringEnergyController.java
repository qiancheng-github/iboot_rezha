package com.iteaj.business.controller;

import com.iteaj.business.domain.MonitoringEnergy;
import com.iteaj.business.service.IMonitoringEnergyService;
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
 * 能源监控Controller
 * 
 * @author qiancheng
 * @date 2025-03-05
 */
@RestController
@RequestMapping("/business/energy")
public class MonitoringEnergyController extends BaseController
{
    @Autowired
    private IMonitoringEnergyService monitoringEnergyService;

    /**
     * 查询能源监控列表
     */
    
    @GetMapping("/list")
    public AjaxResult list(MonitoringEnergy monitoringEnergy)
    {
        startPage();
        List<MonitoringEnergy> list = monitoringEnergyService.selectMonitoringEnergyList(monitoringEnergy);
        return success(list);
    }

    /**
     * 导出能源监控列表
     */
    
    @Log(title = "能源监控", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MonitoringEnergy monitoringEnergy)
    {
        List<MonitoringEnergy> list = monitoringEnergyService.selectMonitoringEnergyList(monitoringEnergy);
        ExcelUtil<MonitoringEnergy> util = new ExcelUtil<MonitoringEnergy>(MonitoringEnergy.class);
        util.exportExcel(response, list, "能源监控数据");
    }

    /**
     * 获取能源监控详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(monitoringEnergyService.selectMonitoringEnergyById(id));
    }

    /**
     * 新增能源监控
     */
    
    @Log(title = "能源监控", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MonitoringEnergy monitoringEnergy)
    {
        return toAjax(monitoringEnergyService.insertMonitoringEnergy(monitoringEnergy));
    }

    /**
     * 修改能源监控
     */
    
    @Log(title = "能源监控", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MonitoringEnergy monitoringEnergy)
    {
        return toAjax(monitoringEnergyService.updateMonitoringEnergy(monitoringEnergy));
    }

    /**
     * 删除能源监控
     */
    
    @Log(title = "能源监控", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(monitoringEnergyService.deleteMonitoringEnergyByIds(ids));
    }

    /**
     * 能源监控-处理获取指定小时数内按能源类型分组的能源监控统计数据
     *
     * @param monitoringEnergy
     * @return 指定时间范围内按能源类型分组的能源监控统计数据列表
     */
    @Anonymous
    @GetMapping("/getEnergyDataByHours")
    public TableDataInfo getEnergyDataByHours(MonitoringEnergy monitoringEnergy) {
        return getDataTable(monitoringEnergyService.getEnergyDataByHours(monitoringEnergy));
    }

    /**
     * 产线能源趋势-根据年月查询各能源类型每天的能源使用数据
     * @param monitoringEnergy
     * @return
     */
    @Anonymous
    @GetMapping("/getDailyUsageByMonth")
    public AjaxResult getDailyUsageByMonth(MonitoringEnergy monitoringEnergy) {
        return success(monitoringEnergyService.getDailyUsageByMonth(monitoringEnergy));
    }

    /**
     * 产线各规格能源趋势-获取产品各规格能耗趋势数据的接口
     * @param monitoringEnergy
     * @return 能耗趋势视图对象
     */
    @Anonymous
    @GetMapping("/getEnergyTrend")
    public AjaxResult getEnergyTrend(MonitoringEnergy monitoringEnergy) {
        return success(monitoringEnergyService.getTrendByEnergy(monitoringEnergy));
    }
}
