package com.iteaj.business.mapper;

import java.util.List;
import com.iteaj.business.domain.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 订单/任务详情Mapper接口
 * 
 * @author qiancheng
 * @date 2025-03-07
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail>
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
     * 删除订单/任务详情
     * 
     * @param id 订单/任务详情主键
     * @return 结果
     */
    public int deleteOrderDetailById(Long id);

    /**
     * 批量删除订单/任务详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderDetailByIds(Long[] ids);
}
