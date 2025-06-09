package com.iteaj.business.service;

import java.util.List;
import com.iteaj.business.domain.OrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 订单/任务详情Service接口
 * 
 * @author qiancheng
 * @date 2025-03-07
 */
public interface IOrderDetailService extends IService<OrderDetail>
{
    /**
     * 查询订单/任务详情
     * 
     * @param id 订单/任务详情主键
     * @return 订单/任务详情
     */
    public OrderDetail selectOrderDetailById(Long id);

    /**
     * 查询订单/任务详情列表
     * 
     * @param orderDetail 订单/任务详情
     * @return 订单/任务详情集合
     */
    public List<OrderDetail> selectOrderDetailList(OrderDetail orderDetail);

    /**
     * 新增订单/任务详情
     * 
     * @param orderDetail 订单/任务详情
     * @return 结果
     */
    public int insertOrderDetail(OrderDetail orderDetail);

    /**
     * 修改订单/任务详情
     * 
     * @param orderDetail 订单/任务详情
     * @return 结果
     */
    public int updateOrderDetail(OrderDetail orderDetail);

    /**
     * 批量删除订单/任务详情
     * 
     * @param ids 需要删除的订单/任务详情主键集合
     * @return 结果
     */
    public int deleteOrderDetailByIds(Long[] ids);

    /**
     * 删除订单/任务详情信息
     * 
     * @param id 订单/任务详情主键
     * @return 结果
     */
    public int deleteOrderDetailById(Long id);
}
