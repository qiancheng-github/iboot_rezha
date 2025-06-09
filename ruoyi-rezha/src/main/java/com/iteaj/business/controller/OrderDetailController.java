package com.iteaj.business.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iteaj.business.annotation.Log;
import com.iteaj.business.core.controller.BaseController;
import com.iteaj.business.core.domain.AjaxResult;
import com.iteaj.business.enums.BusinessType;
import com.iteaj.business.domain.OrderDetail;
import com.iteaj.business.service.IOrderDetailService;
import com.iteaj.business.utils.poi.ExcelUtil;
import com.iteaj.business.core.page.TableDataInfo;

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
    //@PreAuthorize("@ss.hasPermi('business:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrderDetail orderDetail)
    {
        startPage();
        List<OrderDetail> list = orderDetailService.selectOrderDetailList(orderDetail);
        return getDataTable(list);
    }

    /**
     * 导出订单/任务详情列表
     */
    //@PreAuthorize("@ss.hasPermi('business:detail:export')")
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
    //@PreAuthorize("@ss.hasPermi('business:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(orderDetailService.selectOrderDetailById(id));
    }

    /**
     * 新增订单/任务详情
     */
    //@PreAuthorize("@ss.hasPermi('business:detail:add')")
    @Log(title = "订单/任务详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderDetail orderDetail)
    {
        return toAjax(orderDetailService.insertOrderDetail(orderDetail));
    }

    /**
     * 修改订单/任务详情
     */
    //@PreAuthorize("@ss.hasPermi('business:detail:edit')")
    @Log(title = "订单/任务详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderDetail orderDetail)
    {
        return toAjax(orderDetailService.updateOrderDetail(orderDetail));
    }

    /**
     * 删除订单/任务详情
     */
    //@PreAuthorize("@ss.hasPermi('business:detail:remove')")
    @Log(title = "订单/任务详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderDetailService.deleteOrderDetailByIds(ids));
    }
}
