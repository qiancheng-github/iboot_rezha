package com.iteaj.business.controller;

import com.iteaj.business.domain.EnergyType;
import com.iteaj.business.service.IEnergyTypeService;
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
 * 能源类型Controller
 * 
 * @author qiancheng
 * @date 2025-03-05
 */
@RestController
@RequestMapping("/business/type")
public class EnergyTypeController extends BaseController
{
    @Autowired
    private IEnergyTypeService energyTypeService;

    /**
     * 查询能源类型列表
     */
    //@PreAuthorize("@ss.hasPermi('business:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(EnergyType energyType)
    {
        startPage();
        List<EnergyType> list = energyTypeService.selectEnergyTypeList(energyType);
        return getDataTable(list);
    }

    /**
     * 导出能源类型列表
     */
    //@PreAuthorize("@ss.hasPermi('business:type:export')")
    @Log(title = "能源类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EnergyType energyType)
    {
        List<EnergyType> list = energyTypeService.selectEnergyTypeList(energyType);
        ExcelUtil<EnergyType> util = new ExcelUtil<EnergyType>(EnergyType.class);
        util.exportExcel(response, list, "能源类型数据");
    }

    /**
     * 获取能源类型详细信息
     */
    //@PreAuthorize("@ss.hasPermi('business:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(energyTypeService.selectEnergyTypeById(id));
    }

    /**
     * 新增能源类型
     */
    //@PreAuthorize("@ss.hasPermi('business:type:add')")
    @Log(title = "能源类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EnergyType energyType)
    {
        return toAjax(energyTypeService.insertEnergyType(energyType));
    }

    /**
     * 修改能源类型
     */
    //@PreAuthorize("@ss.hasPermi('business:type:edit')")
    @Log(title = "能源类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EnergyType energyType)
    {
        return toAjax(energyTypeService.updateEnergyType(energyType));
    }

    /**
     * 删除能源类型
     */
    //@PreAuthorize("@ss.hasPermi('business:type:remove')")
    @Log(title = "能源类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(energyTypeService.deleteEnergyTypeByIds(ids));
    }
}
