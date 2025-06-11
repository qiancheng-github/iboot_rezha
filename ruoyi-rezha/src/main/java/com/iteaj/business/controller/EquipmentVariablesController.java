package com.iteaj.business.controller;

import com.iteaj.business.domain.EquipmentVariables;
import com.iteaj.business.service.IEquipmentVariablesService;
import com.iteaj.business.vo.StripTemMonitorVO;
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
 * 存储设备变量参数信息的Controller
 * 
 * @author ldkj
 * @date 2025-02-27
 */
@RestController
@RequestMapping("/deviceInfo/variables")
public class EquipmentVariablesController extends BaseController
{
    @Autowired
    private IEquipmentVariablesService equipmentVariablesService;

    /**
     * 查询存储设备变量参数信息的列表
     */
    
    @GetMapping("/list")
    public TableDataInfo list(EquipmentVariables equipmentVariables)
    {
        startPage();
        List<EquipmentVariables> list = equipmentVariablesService.selectEquipmentVariablesList(equipmentVariables);
        return getDataTable(list);
    }

    /**
     * 导出存储设备变量参数信息的列表
     */
    
    @Log(title = "存储设备变量参数信息的", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EquipmentVariables equipmentVariables)
    {
        List<EquipmentVariables> list = equipmentVariablesService.selectEquipmentVariablesList(equipmentVariables);
        ExcelUtil<EquipmentVariables> util = new ExcelUtil<EquipmentVariables>(EquipmentVariables.class);
        util.exportExcel(response, list, "存储设备变量参数信息的数据");
    }

    /**
     * 获取存储设备变量参数信息的详细信息
     */
    
    @GetMapping(value = "/{variableId}")
    public AjaxResult getInfo(@PathVariable("variableId") Long variableId)
    {
        return success(equipmentVariablesService.selectEquipmentVariablesByVariableId(variableId));
    }

    /**
     * 新增存储设备变量参数信息的
     */
    
    @Log(title = "存储设备变量参数信息的", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentVariables equipmentVariables)
    {
        return toAjax(equipmentVariablesService.insertEquipmentVariables(equipmentVariables));
    }

    /**
     * 修改存储设备变量参数信息的
     */
    
    @Log(title = "存储设备变量参数信息的", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentVariables equipmentVariables)
    {
        return toAjax(equipmentVariablesService.updateEquipmentVariables(equipmentVariables));
    }

    /**
     * 删除存储设备变量参数信息的
     */
    
    @Log(title = "存储设备变量参数信息的", businessType = BusinessType.DELETE)
	@DeleteMapping("/{variableIds}")
    public AjaxResult remove(@PathVariable Long[] variableIds)
    {
        return toAjax(equipmentVariablesService.deleteEquipmentVariablesByVariableIds(variableIds));
    }

    /**
     * 生产管理->>带钢温度监控->>获取电磁感应入口温度
     * @param equipmentVariables
     * @return
     */
    @Anonymous
    @GetMapping("/getStrpTempVo")
    public AjaxResult getStrpTempVo(EquipmentVariables equipmentVariables) {
        StripTemMonitorVO vo = equipmentVariablesService.getStrpTempVo(equipmentVariables);
        return AjaxResult.success(vo);
    }

    /**
     * 生产管理->>激光扫描->>获取激光扫描结果
     * @param equipmentVariables
     * @return
     */
    @Anonymous
    @GetMapping("/getLaserScan")
    public TableDataInfo getLaserScanResult(EquipmentVariables equipmentVariables) {
        return getDataTable(equipmentVariablesService.getLaserScanResult(equipmentVariables));
    }

}
