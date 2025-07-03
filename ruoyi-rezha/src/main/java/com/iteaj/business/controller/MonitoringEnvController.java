package com.iteaj.business.controller;

import com.iteaj.business.domain.MonitoringEnv;
import com.iteaj.business.service.IMonitoringEnvService;
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
 * 监控_环境Controller
 * 
 * @author qiancheng
 * @date 2025-03-05
 */
@RestController
@RequestMapping("/business/env")
public class MonitoringEnvController extends BaseController
{
    @Autowired
    private IMonitoringEnvService monitoringEnvService;

    /**
     * 查询监控_环境列表
     */
    @Anonymous
    @GetMapping("/list")
    public AjaxResult list(MonitoringEnv monitoringEnv)
    {
        startPage();
        List<MonitoringEnv> list = monitoringEnvService.selectMonitoringEnvList(monitoringEnv);
        return success(list);
    }

    /**
     * 导出监控_环境列表
     */
    
    @Log(title = "监控_环境", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MonitoringEnv monitoringEnv)
    {
        List<MonitoringEnv> list = monitoringEnvService.selectMonitoringEnvList(monitoringEnv);
        ExcelUtil<MonitoringEnv> util = new ExcelUtil<MonitoringEnv>(MonitoringEnv.class);
        util.exportExcel(response, list, "监控_环境数据");
    }

    /**
     * 获取监控_环境详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(monitoringEnvService.selectMonitoringEnvById(id));
    }

    /**
     * 新增监控_环境
     */
    
    @Log(title = "监控_环境", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MonitoringEnv monitoringEnv)
    {
        return toAjax(monitoringEnvService.insertMonitoringEnv(monitoringEnv));
    }

    /**
     * 修改监控_环境
     */
    
    @Log(title = "监控_环境", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MonitoringEnv monitoringEnv)
    {
        return toAjax(monitoringEnvService.updateMonitoringEnv(monitoringEnv));
    }

    /**
     * 删除监控_环境
     */
    
    @Log(title = "监控_环境", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(monitoringEnvService.deleteMonitoringEnvByIds(ids));
    }
}
