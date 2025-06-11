package com.iteaj.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iteaj.business.domain.OrderMain;
import com.iteaj.business.vo.OperationDataVO;
import com.iteaj.business.vo.OrderChartVO;

import java.util.List;

/**
 * 订单/任务主Service接口
 * 
 * @author qiancheng
 * @date 2025-03-07
 */
public interface IOrderMainService extends IService<OrderMain>
{
    /**
     * 查询订单/任务主
     * 
     * @param id 订单/任务主主键
     * @return 订单/任务主
     */
    public OrderMain selectOrderMainById(Long id);

    /**
     * 查询订单/任务主列表
     * 
     * @param orderMain 订单/任务主
     * @return 订单/任务主集合
     */
    public List<OrderMain> selectOrderMainList(OrderMain orderMain);

    /**
     * 新增订单/任务主
     * 
     * @param orderMain 订单/任务主
     * @return 结果
     */
    public int insertOrderMain(OrderMain orderMain);

    /**
     * 修改订单/任务主
     * 
     * @param orderMain 订单/任务主
     * @return 结果
     */
    public int updateOrderMain(OrderMain orderMain);

    /**
     * 批量删除订单/任务主
     * 
     * @param ids 需要删除的订单/任务主主键集合
     * @return 结果
     */
    public int deleteOrderMainByIds(Long[] ids);

    /**
     * 删除订单/任务主信息
     * 
     * @param id 订单/任务主主键
     * @return 结果
     */
    public int deleteOrderMainById(Long id);

    /**
     * 获取订单编号
     *
     * @return 订单编号
     */
    public String getOrderCode();

    /**
     * 根据年份获取运营数据
     * @return 运营数据值对象
     */
    OperationDataVO getOperationDataByYear(OrderMain orderMain);

    /**
     * 根据年份和月份获取生产统计数据
     * @return 运营数据值对象
     */
    OperationDataVO getOpDataByOrder(OrderMain orderMain);

    /**
     * 根据订单主表信息获取用于生产图表的数据。
     *
     * @param orderMain
     * @return 订单图表数据值对象，包含横坐标数据、实际生产数据和计划生产数据。
     */
    OrderChartVO getOrderChartData(OrderMain orderMain);

    /**
     * 生产管理-生产计划-获取订单详情
     * @param orderMain
     * @return
     */
    OrderMain getOrderDetails(OrderMain orderMain);

    /**
     * 根据订单主表信息获取用于生产趋势分析图表的数据。
     *
     * @param orderMain
     * @return 生产趋势分析图表数据值对象，包含横坐标数据、实际生产数据和计划生产数据。
     */
    OrderChartVO getProductionTrend(OrderMain orderMain);

}
