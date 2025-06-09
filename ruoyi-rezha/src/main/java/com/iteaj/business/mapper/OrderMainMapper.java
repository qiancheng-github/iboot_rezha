package com.iteaj.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iteaj.business.domain.OrderDetail;
import com.iteaj.business.domain.OrderMain;
import com.iteaj.business.vo.OperationDataVO;
import com.iteaj.business.vo.OrderChartVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单/任务主Mapper接口
 * 
 * @author qiancheng
 * @date 2025-03-07
 */
@Mapper
public interface OrderMainMapper extends BaseMapper<OrderMain>
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
     * 删除订单/任务主
     * 
     * @param id 订单/任务主主键
     * @return 结果
     */
    public int deleteOrderMainById(Long id);

    /**
     * 批量删除订单/任务主
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderMainByIds(Long[] ids);

    /**
     * 批量删除订单/任务详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderDetailByOrderCodes(Long[] ids);
    
    /**
     * 批量新增订单/任务详情
     * 
     * @param orderDetailList 订单/任务详情列表
     * @return 结果
     */
    public int batchOrderDetail(List<OrderDetail> orderDetailList);
    

    /**
     * 通过订单/任务主主键删除订单/任务详情信息
     * 
     * @param id 订单/任务主ID
     * @return 结果
     */
    public int deleteOrderDetailByOrderCode(Long id);

    /**
     * 获取订单编号
     *
     * @return 订单编号
     */
    public String getOrderCode(OrderMain orderMain);

    /**
     * 根据年份获取运营数据
     * @return 运营数据值对象
     */
    OperationDataVO getOperationDataByYear(OrderMain orderMain);

    /**
     * 根据年份和月份获取运营数据
     * @return 运营数据值对象
     */
    OperationDataVO getOpDataByOrder(OrderMain orderMain);

    /**
     * 根据订单主表信息获取用于生产图表的数据。
     *
     * @param orderMain 包含订单年份和月份信息的 OrderMain 对象，用于筛选符合条件的订单数据。
     * @return 订单图表数据值对象，包含横坐标数据、实际生产数据和计划生产数据。
     */
    List<OrderChartVO> getOrderChartData(OrderMain orderMain);

    /**
     * 根据订单编号获取订单主表信息
     * @param orderMain 包含订单编号信息的 OrderMain 对象
     * @return 订单主表信息
     */
    OrderMain getOrderMainByCode(OrderMain orderMain);

    /**
     * 根据订单主表信息获取用于生产趋势分析图表的数据。
     *
     * @param orderMain
     * @return 生产趋势分析图表数据值对象，包含横坐标数据、实际生产数据和计划生产数据。
     */
    List<OrderChartVO> getProductionTrend(OrderMain orderMain);
}
