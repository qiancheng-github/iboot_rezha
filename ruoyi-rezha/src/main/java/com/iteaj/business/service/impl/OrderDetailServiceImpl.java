package com.iteaj.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iteaj.business.domain.OrderDetail;
import com.iteaj.business.mapper.OrderDetailMapper;
import com.iteaj.business.service.IOrderDetailService;
import com.iteaj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单/任务详情Service业务层处理
 * 
 * @author qiancheng
 * @date 2025-03-07
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService
{
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     * 查询订单/任务详情
     * 
     * @param id 订单/任务详情主键
     * @return 订单/任务详情
     */
    @Override
    public OrderDetail selectOrderDetailById(Long id)
    {
        return orderDetailMapper.selectOrderDetailById(id);
    }

    /**
     * 查询订单/任务详情列表
     * 
     * @param orderDetail 订单/任务详情
     * @return 订单/任务详情
     */
    @Override
    public List<OrderDetail> selectOrderDetailList(OrderDetail orderDetail)
    {
        return orderDetailMapper.selectOrderDetailList(orderDetail);
    }

    /**
     * 新增订单/任务详情
     * 
     * @param orderDetail 订单/任务详情
     * @return 结果
     */
    @Override
    public int insertOrderDetail(OrderDetail orderDetail)
    {
        orderDetail.setCreateTime(DateUtils.getNowDate());
        return orderDetailMapper.insert(orderDetail);
    }

    /**
     * 修改订单/任务详情
     * 
     * @param orderDetail 订单/任务详情
     * @return 结果
     */
    @Override
    public int updateOrderDetail(OrderDetail orderDetail)
    {
        orderDetail.setUpdateTime(DateUtils.getNowDate());
        return orderDetailMapper.updateOrderDetail(orderDetail);
    }

    /**
     * 批量删除订单/任务详情
     * 
     * @param ids 需要删除的订单/任务详情主键
     * @return 结果
     */
    @Override
    public int deleteOrderDetailByIds(Long[] ids)
    {
        return orderDetailMapper.deleteOrderDetailByIds(ids);
    }

    /**
     * 删除订单/任务详情信息
     * 
     * @param id 订单/任务详情主键
     * @return 结果
     */
    @Override
    public int deleteOrderDetailById(Long id)
    {
        return orderDetailMapper.deleteOrderDetailById(id);
    }
}
