package com.iteaj.business.controller;

import com.iteaj.business.domain.OrderDetail;
import com.iteaj.business.service.IOrderDetailService;
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
 * 订单/任务详情Controller
 * 
 * @author qiancheng
 * @date 2025-03-07
 */
@RestController
@RequestMapping("/business/detail")
public class OrderDetailController extends BaseController
{
    @Autowired
    private IOrderDetailService orderDetailService;

    /**
     * 查询订单/任务详情列表
     */
    
    @GetMapping("/list")
    public AjaxResult list(OrderDetail orderDetail)
    {
        startPage();
        List<OrderDetail> list = orderDetailService.selectOrderDetailList(orderDetail);
        return success(list);
    }

    /**
     * 导出订单/任务详情列表
     */
    
    @Log(title = "订单/任务详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrderDetail orderDetail)
    {
        List<OrderDetail> list = orderDetailService.selectOrderDetailList(orderDetail);
        ExcelUtil<OrderDetail> util = new ExcelUtil<OrderDetail>(OrderDetail.class);
        util.exportExcel(response, list, "订单/任务详情数据");
    }

    /**
     * 获取订单/任务详情详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(orderDetailService.selectOrderDetailById(id));
    }

    /**
     * 新增订单/任务详情
     */
    
    @Log(title = "订单/任务详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderDetail orderDetail)
    {
        return toAjax(orderDetailService.insertOrderDetail(orderDetail));
    }

    /**
     * 修改订单/任务详情
     */
    
    @Log(title = "订单/任务详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderDetail orderDetail)
    {
        return toAjax(orderDetailService.updateOrderDetail(orderDetail));
    }

    /**
     * 删除订单/任务详情
     */
    
    @Log(title = "订单/任务详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderDetailService.deleteOrderDetailByIds(ids));
    }
}
