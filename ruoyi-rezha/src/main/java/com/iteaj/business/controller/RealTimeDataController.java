package com.iteaj.business.controller;

import com.iteaj.business.domain.RealTimeData;
import com.iteaj.business.service.IRealTimeDataService;
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
 * 实时数据Controller
 * 
 * @author ldkj
 * @date 2025-02-26
 */
@RestController
@RequestMapping("/businessInfo/realTimeData")
public class RealTimeDataController extends BaseController
{
    @Autowired
    private IRealTimeDataService realTimeDataService;

    /**
     * 查询实时数据列表
     */
    
    @GetMapping("/list")
    public TableDataInfo list(RealTimeData realTimeData)
    {
        startPage();
        List<RealTimeData> list = realTimeDataService.selectRealTimeDataList(realTimeData);
        return getDataTable(list);
    }

    /**
     * 导出实时数据列表
     */
    
    @Log(title = "实时数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RealTimeData realTimeData)
    {
        List<RealTimeData> list = realTimeDataService.selectRealTimeDataList(realTimeData);
        ExcelUtil<RealTimeData> util = new ExcelUtil<RealTimeData>(RealTimeData.class);
        util.exportExcel(response, list, "实时数据数据");
    }

    /**
     * 获取实时数据详细信息
     */
    
    @GetMapping(value = "/{variableId}")
    public AjaxResult getInfo(@PathVariable("variableId") Long variableId)
    {
        return success(realTimeDataService.selectRealTimeDataByVariableId(variableId));
    }

    /**
     * 新增实时数据
     */
    
    @Log(title = "实时数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RealTimeData realTimeData)
    {
        return toAjax(realTimeDataService.insertRealTimeData(realTimeData));
    }

    /**
     * 修改实时数据
     */
    
    @Log(title = "实时数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RealTimeData realTimeData)
    {
        return toAjax(realTimeDataService.updateRealTimeData(realTimeData));
    }

    /**
     * 删除实时数据
     */
    
    @Log(title = "实时数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{variableIds}")
    public AjaxResult remove(@PathVariable Long[] variableIds)
    {
        return toAjax(realTimeDataService.deleteRealTimeDataByVariableIds(variableIds));
    }
}
