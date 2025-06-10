package com.iteaj.business.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iteaj.business.domain.EnergyType;
import com.iteaj.business.service.IEnergyTypeService;
import com.iteaj.common.annotation.Anonymous;
import com.iteaj.common.core.page.TableDataInfo;
import com.iteaj.framework.BaseController;
import com.iteaj.framework.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Anonymous
    @GetMapping("/hello")
    public String hello() {
        return "Hello111!";
    }

    /**
     * 查询能源类型列表
     */

    @GetMapping("/list")
    public Result<IPage<EnergyType>> list(Page<EnergyType> page, EnergyType energyType)
    {


        return energyTypeService.selectEnergyTypeList(page,energyType);
    }

}
