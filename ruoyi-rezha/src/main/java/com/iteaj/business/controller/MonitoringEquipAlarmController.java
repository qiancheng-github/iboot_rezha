package com.iteaj.business.controller;

import com.iteaj.business.domain.MonitoringEquipAlarm;
import com.iteaj.business.service.IMonitoringEquipAlarmService;
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
 * 监控_设备预警Controller
 * 
 * @author qiancheng
 * @date 2025-03-05
 */
@RestController
@RequestMapping("/business/alarm")
public class MonitoringEquipAlarmController extends BaseController
{
    @Autowired
    private IMonitoringEquipAlarmService monitoringEquipAlarmService;

    /**
     * 查询监控_设备预警列表
     */
    @Anonymous
    @GetMapping("/list")
    public AjaxResult list(MonitoringEquipAlarm monitoringEquipAlarm)
    {
        startPage();
        List<MonitoringEquipAlarm> list = monitoringEquipAlarmService.selectMonitoringEquipAlarmList(monitoringEquipAlarm);
        return success(list);
    }

    /**
     * 导出监控_设备预警列表
     */
    
    @Log(title = "监控_设备预警", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MonitoringEquipAlarm monitoringEquipAlarm)
    {
        List<MonitoringEquipAlarm> list = monitoringEquipAlarmService.selectMonitoringEquipAlarmList(monitoringEquipAlarm);
        ExcelUtil<MonitoringEquipAlarm> util = new ExcelUtil<MonitoringEquipAlarm>(MonitoringEquipAlarm.class);
        util.exportExcel(response, list, "监控_设备预警数据");
    }

    /**
     * 获取监控_设备预警详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(monitoringEquipAlarmService.selectMonitoringEquipAlarmById(id));
    }

    /**
     * 新增监控_设备预警
     */
    
    @Log(title = "监控_设备预警", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MonitoringEquipAlarm monitoringEquipAlarm)
    {
        return toAjax(monitoringEquipAlarmService.insertMonitoringEquipAlarm(monitoringEquipAlarm));
    }

    /**
     * 修改监控_设备预警
     */
    
    @Log(title = "监控_设备预警", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MonitoringEquipAlarm monitoringEquipAlarm)
    {
        return toAjax(monitoringEquipAlarmService.updateMonitoringEquipAlarm(monitoringEquipAlarm));
    }

    /**
     * 删除监控_设备预警
     */
    
    @Log(title = "监控_设备预警", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(monitoringEquipAlarmService.deleteMonitoringEquipAlarmByIds(ids));
    }

    /**
     * 安全预警-获取预警数量
     * @param monitoringEquipAlarm
     * @return AlarmStatsVO对象，以JSON格式返回给前端，包含该年份的安全预警统计信息
     */
    @GetMapping("/getAlarmStats")
    public AjaxResult getAlarmStats(MonitoringEquipAlarm monitoringEquipAlarm) {
        // 调用Service接口的方法，获取指定年份的设备安全预警统计信息并返回
        return success(monitoringEquipAlarmService.getAlarmStats(monitoringEquipAlarm));
    }
}
