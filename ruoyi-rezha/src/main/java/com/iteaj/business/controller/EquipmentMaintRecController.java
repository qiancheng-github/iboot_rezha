package com.iteaj.business.controller;

import com.iteaj.business.domain.EquipmentMaintRec;
import com.iteaj.business.service.IEquipmentMaintRecService;
import com.iteaj.business.annotation.Anonymous;
import com.iteaj.business.annotation.Log;
import com.iteaj.business.core.controller.BaseController;
import com.iteaj.business.core.domain.AjaxResult;
import com.iteaj.business.core.page.TableDataInfo;
import com.iteaj.business.enums.BusinessType;
import com.iteaj.business.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 设备维护记录Controller
 * 
 * @author qiancheng
 * @date 2025-03-05
 */
@RestController
@RequestMapping("/business/rec")
public class EquipmentMaintRecController extends BaseController
{
    @Autowired
    private IEquipmentMaintRecService equipmentMaintRecService;

    /**
     * 查询设备维护记录列表
     */
    //@PreAuthorize("@ss.hasPermi('business:rec:list')")
    @GetMapping("/list")
    public TableDataInfo list(EquipmentMaintRec equipmentMaintRec)
    {
        startPage();
        List<EquipmentMaintRec> list = equipmentMaintRecService.selectEquipmentMaintRecList(equipmentMaintRec);
        return getDataTable(list);
    }

    /**
     * 导出设备维护记录列表
     */
    //@PreAuthorize("@ss.hasPermi('business:rec:export')")
    @Log(title = "设备维护记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EquipmentMaintRec equipmentMaintRec)
    {
        List<EquipmentMaintRec> list = equipmentMaintRecService.selectEquipmentMaintRecList(equipmentMaintRec);
        ExcelUtil<EquipmentMaintRec> util = new ExcelUtil<EquipmentMaintRec>(EquipmentMaintRec.class);
        util.exportExcel(response, list, "设备维护记录数据");
    }

    /**
     * 获取设备维护记录详细信息
     */
    //@PreAuthorize("@ss.hasPermi('business:rec:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(equipmentMaintRecService.selectEquipmentMaintRecByRecordId(recordId));
    }

    /**
     * 新增设备维护记录
     */
    //@PreAuthorize("@ss.hasPermi('business:rec:add')")
    @Log(title = "设备维护记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentMaintRec equipmentMaintRec)
    {
        return toAjax(equipmentMaintRecService.insertEquipmentMaintRec(equipmentMaintRec));
    }

    /**
     * 修改设备维护记录
     */
    //@PreAuthorize("@ss.hasPermi('business:rec:edit')")
    @Log(title = "设备维护记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentMaintRec equipmentMaintRec)
    {
        return toAjax(equipmentMaintRecService.updateEquipmentMaintRec(equipmentMaintRec));
    }

    /**
     * 删除设备维护记录
     */
    //@PreAuthorize("@ss.hasPermi('business:rec:remove')")
    @Log(title = "设备维护记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(equipmentMaintRecService.deleteEquipmentMaintRecByRecordIds(recordIds));
    }

    /**
     * 设备维护记录_查询设备维护记录列表
     * @param equipmentMaintRec
     * @return
     */
    @Anonymous
    @GetMapping("/getMaintRecListByYear")
    public AjaxResult getMaintRecListByYear(EquipmentMaintRec equipmentMaintRec) {
         return success(equipmentMaintRecService.getMaintRecListByYear(equipmentMaintRec));
    }
}
