package com.iteaj.business.controller;

import com.iteaj.business.domain.EquipmentMaintRec;
import com.iteaj.business.service.IEquipmentMaintRecService;
import com.iteaj.common.core.controller.BaseController;
import com.iteaj.common.core.domain.AjaxResult;
import com.iteaj.common.core.page.TableDataInfo;

import com.iteaj.common.utils.poi.ExcelUtil;
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
    @GetMapping("/list")
    public AjaxResult list(EquipmentMaintRec equipmentMaintRec)
    {
        startPage();
        List<EquipmentMaintRec> list = equipmentMaintRecService.selectEquipmentMaintRecList(equipmentMaintRec);
        return success(list);
    }

    /**
     * 导出设备维护记录列表
     */
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
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(equipmentMaintRecService.selectEquipmentMaintRecByRecordId(recordId));
    }

    /**
     * 新增设备维护记录
     */
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentMaintRec equipmentMaintRec)
    {
        return toAjax(equipmentMaintRecService.insertEquipmentMaintRec(equipmentMaintRec));
    }

    /**
     * 修改设备维护记录
     */
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentMaintRec equipmentMaintRec)
    {
        return toAjax(equipmentMaintRecService.updateEquipmentMaintRec(equipmentMaintRec));
    }

    /**
     * 删除设备维护记录
     */
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
    @GetMapping("/getMaintRecListByYear")
    public AjaxResult getMaintRecListByYear(EquipmentMaintRec equipmentMaintRec) {
         return success(equipmentMaintRecService.getMaintRecListByYear(equipmentMaintRec));
    }
}
