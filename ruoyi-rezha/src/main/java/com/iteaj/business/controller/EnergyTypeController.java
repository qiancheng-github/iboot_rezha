package com.iteaj.business.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iteaj.business.domain.EnergyType;
import com.iteaj.business.service.IEnergyTypeService;
import com.iteaj.common.core.controller.BaseController;
import com.iteaj.common.core.domain.AjaxResult;
import com.iteaj.framework.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/list")
    public Result<IPage<EnergyType>> list(Page<EnergyType> page, EnergyType energyType)
    {
        return energyTypeService.selectEnergyTypeList(page,energyType);
    }

    /**
     * 获取能源类型详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(energyTypeService.selectEnergyTypeById(id));
    }

    /**
     * 新增能源类型
     */
    @PostMapping
    public AjaxResult add(@RequestBody EnergyType energyType)
    {
        return toAjax(energyTypeService.insertEnergyType(energyType));
    }

    /**
     * 修改能源类型
     */
    @PutMapping
    public AjaxResult edit(@RequestBody EnergyType energyType)
    {
        return toAjax(energyTypeService.updateEnergyType(energyType));
    }

    /**
     * 删除能源类型
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(energyTypeService.deleteEnergyTypeByIds(ids));
    }

}
