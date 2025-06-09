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
import com.iteaj.business.domain.RealTimeData;
import com.iteaj.business.service.IRealTimeDataService;
import com.iteaj.business.utils.poi.ExcelUtil;
import com.iteaj.business.core.page.TableDataInfo;

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
    //@PreAuthorize("@ss.hasPermi('businessInfo:realTimeData:list')")
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
    //@PreAuthorize("@ss.hasPermi('businessInfo:realTimeData:export')")
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
    //@PreAuthorize("@ss.hasPermi('businessInfo:realTimeData:query')")
    @GetMapping(value = "/{variableId}")
    public AjaxResult getInfo(@PathVariable("variableId") Long variableId)
    {
        return success(realTimeDataService.selectRealTimeDataByVariableId(variableId));
    }

    /**
     * 新增实时数据
     */
    //@PreAuthorize("@ss.hasPermi('businessInfo:realTimeData:add')")
    @Log(title = "实时数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RealTimeData realTimeData)
    {
        return toAjax(realTimeDataService.insertRealTimeData(realTimeData));
    }

    /**
     * 修改实时数据
     */
    //@PreAuthorize("@ss.hasPermi('businessInfo:realTimeData:edit')")
    @Log(title = "实时数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RealTimeData realTimeData)
    {
        return toAjax(realTimeDataService.updateRealTimeData(realTimeData));
    }

    /**
     * 删除实时数据
     */
    //@PreAuthorize("@ss.hasPermi('businessInfo:realTimeData:remove')")
    @Log(title = "实时数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{variableIds}")
    public AjaxResult remove(@PathVariable Long[] variableIds)
    {
        return toAjax(realTimeDataService.deleteRealTimeDataByVariableIds(variableIds));
    }
}
