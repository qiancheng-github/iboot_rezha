package com.iteaj.business.controller;

import com.iteaj.business.domain.EquipmentTypes;
import com.iteaj.business.service.IEquipmentTypesService;
import com.iteaj.business.vo.EquipPredictDetailVO;
import com.iteaj.business.vo.EquipPredictVO;
import com.iteaj.common.annotation.Anonymous;
import com.iteaj.common.annotation.Log;
import com.iteaj.common.core.controller.BaseController;
import com.iteaj.common.core.domain.AjaxResult;
import com.iteaj.common.enums.BusinessType;
import com.iteaj.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 存储设备类型信息的，支持树状结构Controller
 * 
 * @author ldkj
 * @date 2025-02-27
 */
@RestController
@RequestMapping("/business/types")
public class EquipmentTypesController extends BaseController
{
    @Autowired
    private IEquipmentTypesService equipmentTypesService;

    /**
     * 查询存储设备类型信息的，支持树状结构列表
     */
    
    @GetMapping("/list")
    public AjaxResult list(EquipmentTypes equipmentTypes)
    {
        List<EquipmentTypes> list = equipmentTypesService.selectEquipmentTypesList(equipmentTypes);
        return success(list);
    }

    /**
     * 导出存储设备类型信息的，支持树状结构列表
     */
    
    @Log(title = "存储设备类型信息的，支持树状结构", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EquipmentTypes equipmentTypes)
    {
        List<EquipmentTypes> list = equipmentTypesService.selectEquipmentTypesList(equipmentTypes);
        ExcelUtil<EquipmentTypes> util = new ExcelUtil<EquipmentTypes>(EquipmentTypes.class);
        util.exportExcel(response, list, "存储设备类型信息的，支持树状结构数据");
    }

    /**
     * 获取存储设备类型信息的，支持树状结构详细信息
     */
    
    @GetMapping(value = "/{equipmentTypeId}")
    public AjaxResult getInfo(@PathVariable("equipmentTypeId") Long equipmentTypeId)
    {
        return success(equipmentTypesService.selectEquipmentTypesByEquipmentTypeId(equipmentTypeId));
    }

    /**
     * 新增存储设备类型信息的，支持树状结构
     */
    
    @Log(title = "存储设备类型信息的，支持树状结构", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentTypes equipmentTypes)
    {
        return toAjax(equipmentTypesService.insertEquipmentTypes(equipmentTypes));
    }

    /**
     * 修改存储设备类型信息的，支持树状结构
     */
    
    @Log(title = "存储设备类型信息的，支持树状结构", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentTypes equipmentTypes)
    {
        return toAjax(equipmentTypesService.updateEquipmentTypes(equipmentTypes));
    }

    /**
     * 删除存储设备类型信息的，支持树状结构
     */
    
    @Log(title = "存储设备类型信息的，支持树状结构", businessType = BusinessType.DELETE)
	@DeleteMapping("/{equipmentTypeIds}")
    public AjaxResult remove(@PathVariable Long[] equipmentTypeIds)
    {
        return toAjax(equipmentTypesService.deleteEquipmentTypesByEquipmentTypeIds(equipmentTypeIds));
    }

    /**
     * 设备总览-获取设备状态数量
     * @param equipmentTypes
     * @return
     */
    @Anonymous
    @GetMapping("/getEquipmentOverview")
    public AjaxResult getEquipmentOverview(EquipmentTypes equipmentTypes) {
        return success(equipmentTypesService.getEquipOverview(equipmentTypes));
    }

    /**
     * 设备管理->>设备预测->>获取设备预测汇总信息
     * @param equipmentTypes
     * @return
     */
    @Anonymous
    @GetMapping("/getEquipPredict")
    public AjaxResult getEquipPredict(EquipmentTypes equipmentTypes) {
        EquipPredictVO vo = equipmentTypesService.getEquipPredict(equipmentTypes);
        return AjaxResult.success(vo);
    }

    /**
     * 设备管理->>设备预测->>获取设备预测信息列表
     * @param equipmentTypes
     * @return
     */
    @Anonymous
    @GetMapping("/getEquipDetailList")
    public AjaxResult getEquipDetailList(EquipmentTypes equipmentTypes) {
        List<EquipPredictDetailVO> list = equipmentTypesService.getEquipPredictDetailList(equipmentTypes);
        return AjaxResult.success(list);
    }

}
