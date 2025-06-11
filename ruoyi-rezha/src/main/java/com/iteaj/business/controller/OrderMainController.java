package com.iteaj.business.controller;

import com.iteaj.business.domain.OrderMain;
import com.iteaj.business.service.IOrderMainService;
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
 * 订单/任务主Controller
 * 
 * @author qiancheng
 * @date 2025-03-07
 */
@RestController
@RequestMapping("/business/main")
public class OrderMainController extends BaseController
{
    @Autowired
    private IOrderMainService orderMainService;

    /**
     * 查询订单/任务主列表
     */
    @Anonymous
    @GetMapping("/list")
    public TableDataInfo list(OrderMain orderMain)
    {
        startPage();
        List<OrderMain> list = orderMainService.selectOrderMainList(orderMain);
        return getDataTable(list);
    }

    /**
     * 导出订单/任务主列表
     */
    
    @Log(title = "订单/任务主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrderMain orderMain)
    {
        List<OrderMain> list = orderMainService.selectOrderMainList(orderMain);
        ExcelUtil<OrderMain> util = new ExcelUtil<OrderMain>(OrderMain.class);
        util.exportExcel(response, list, "订单主数据");
    }

    /**
     * 获取订单/任务主详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(orderMainService.selectOrderMainById(id));
    }

    /**
     * 新增订单/任务主
     */
    
    @Log(title = "订单/任务主", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderMain orderMain)
    {
        return toAjax(orderMainService.insertOrderMain(orderMain));
    }

    /**
     * 修改订单/任务主
     */
    
    @Log(title = "订单/任务主", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderMain orderMain)
    {
        return toAjax(orderMainService.updateOrderMain(orderMain));
    }

    /**
     * 删除订单/任务主
     */
    
    @Log(title = "订单/任务主", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderMainService.deleteOrderMainByIds(ids));
    }

    /**
     * 获取订单编号
     */
    
    @Log(title = "订单/任务主", businessType = BusinessType.DELETE)
    @GetMapping("/getOrderCode")
    public AjaxResult getOrderCode()
    {
        return success(orderMainService.getOrderCode());
    }

    /**
     * 首页-根据年月获取运营数据
     */
    @Anonymous
    @Log(title = "根据年月获取运营数据", businessType = BusinessType.DELETE)
    @GetMapping("/getOperationData")
    public AjaxResult getOperationData(OrderMain orderMain)
    {
        orderMain.getOrderCode();
        return success(orderMainService.getOperationDataByYear(orderMain));
    }

    /**
     * 首页-根据年月获取生产统计
     * @return 运营数据值对象
     */
    @Anonymous
    @GetMapping("/getOpDataByOrder")
    public AjaxResult getOpDataByOrder(OrderMain orderMain) {
        return success(orderMainService.getOpDataByOrder(orderMain));
    }

    /**
     * 首页-根据年月获取生产统计图表数据
     *
     * @param orderMain
     * @return 订单图表数据值对象，包含横坐标数据、实际生产数据和计划生产数据。
     */
    @Anonymous
    @GetMapping("/getOrderChartData")
    public AjaxResult getOrderChartData(OrderMain orderMain) {
        // 调用 OrderMainService 的方法，传入 OrderMain 对象，
        // 获取订单图表数据并返回给客户端
        return success(orderMainService.getOrderChartData(orderMain));
    }

    /**
     * 生产管理-生产计划-获取订单详情
     * @param orderMain
     * @return
     */
    @Anonymous
    @GetMapping("/getOrderDetails")
    public AjaxResult getOrderDetails(OrderMain orderMain) {
        return success(orderMainService.getOrderDetails(orderMain));
    }

    /**
     * 生产管理-生产趋势分析-根据年获取图表数据
     *
     * @param orderMain
     * @return
     */
    @Anonymous
    @GetMapping("/getProductionTrend")
    public AjaxResult getProductionTrend(OrderMain orderMain) {
        // 调用ProductionService的方法获取生产趋势数据并返回
        return success(orderMainService.getProductionTrend(orderMain));
    }

}
