package com.iteaj.business.controller;

import com.iteaj.business.domain.HistoricalData;
import com.iteaj.business.service.IHistoricalDataService;
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
 * 历史数据Controller
 * 
 * @author ldkj
 * @date 2025-02-26
 */
@RestController
@RequestMapping("/businessInfo/historicalData")
public class HistoricalDataController extends BaseController
{
    @Autowired
    private IHistoricalDataService historicalDataService;

    /**
     * 查询历史数据列表
     */
    
    @GetMapping("/list")
    public TableDataInfo list(HistoricalData historicalData)
    {
        startPage();
        List<HistoricalData> list = historicalDataService.selectHistoricalDataList(historicalData);
        return getDataTable(list);
    }

    /**
     * 导出历史数据列表
     */
    
    @Log(title = "历史数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HistoricalData historicalData)
    {
        List<HistoricalData> list = historicalDataService.selectHistoricalDataList(historicalData);
        ExcelUtil<HistoricalData> util = new ExcelUtil<HistoricalData>(HistoricalData.class);
        util.exportExcel(response, list, "历史数据数据");
    }

    /**
     * 获取历史数据详细信息
     */
    
    @GetMapping(value = "/{dataId}")
    public AjaxResult getInfo(@PathVariable("dataId") Long dataId)
    {
        return success(historicalDataService.selectHistoricalDataByDataId(dataId));
    }

    /**
     * 新增历史数据
     */
    
    @Log(title = "历史数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HistoricalData historicalData)
    {
        return toAjax(historicalDataService.insertHistoricalData(historicalData));
    }

    /**
     * 修改历史数据
     */
    
    @Log(title = "历史数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HistoricalData historicalData)
    {
        return toAjax(historicalDataService.updateHistoricalData(historicalData));
    }

    /**
     * 删除历史数据
     */
    
    @Log(title = "历史数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dataIds}")
    public AjaxResult remove(@PathVariable Long[] dataIds)
    {
        return toAjax(historicalDataService.deleteHistoricalDataByDataIds(dataIds));
    }
}
