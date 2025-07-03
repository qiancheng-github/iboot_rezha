package com.iteaj.business.controller;

import com.iteaj.business.domain.EquipmentPred;
import com.iteaj.business.service.IEquipmentPredService;
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
 * 设备预测Controller
 * 
 * @author qiancheng
 * @date 2025-03-05
 */
@RestController
@RequestMapping("/business/pred")
public class EquipmentPredController extends BaseController
{
    @Autowired
    private IEquipmentPredService equipmentPredService;

    /**
     * 查询设备预测列表
     */
    
    @GetMapping("/list")
    public AjaxResult list(EquipmentPred equipmentPred)
    {
        startPage();
        List<EquipmentPred> list = equipmentPredService.selectEquipmentPredList(equipmentPred);
        return success(list);
    }

    /**
     * 获取设备预测详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(equipmentPredService.selectEquipmentPredById(id));
    }

    /**
     * 新增设备预测
     */
    
    @Log(title = "设备预测", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentPred equipmentPred)
    {
        return toAjax(equipmentPredService.insertEquipmentPred(equipmentPred));
    }

    /**
     * 修改设备预测
     */
    @Log(title = "设备预测", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentPred equipmentPred)
    {
        return toAjax(equipmentPredService.updateEquipmentPred(equipmentPred));
    }

    /**
     * 删除设备预测
     */
    
    @Log(title = "设备预测", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipmentPredService.deleteEquipmentPredByIds(ids));
    }
}
