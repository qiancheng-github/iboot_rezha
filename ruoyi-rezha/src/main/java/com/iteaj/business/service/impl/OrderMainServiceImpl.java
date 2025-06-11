package com.iteaj.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iteaj.business.domain.OrderDetail;
import com.iteaj.business.domain.OrderMain;
import com.iteaj.business.mapper.OrderMainMapper;
import com.iteaj.business.service.IOrderDetailService;
import com.iteaj.business.service.IOrderMainService;
import com.iteaj.business.vo.OperationDataVO;
import com.iteaj.business.vo.OrderChartVO;
import com.iteaj.common.utils.CommentUtil;
import com.iteaj.common.utils.DateUtils;
import com.iteaj.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单/任务主Service业务层处理
 * 
 * @author qiancheng
 * @date 2025-03-07
 */
@Service
public class OrderMainServiceImpl extends ServiceImpl<OrderMainMapper, OrderMain> implements IOrderMainService
{
    @Autowired
    private OrderMainMapper orderMainMapper;
    @Autowired
    private IOrderDetailService orderDetailService;

    /**
     * 查询订单/任务主
     * @param id 订单/任务主主键
     * @return 订单/任务主
     */
    @Override
    public OrderMain selectOrderMainById(Long id)
    {
        return orderMainMapper.selectOrderMainById(id);
    }

    /**
     * 查询订单/任务主列表
     * 
     * @param orderMain 订单/任务主
     * @return 订单/任务主
     */
    @Override
    public List<OrderMain> selectOrderMainList(OrderMain orderMain)
    {
        CommentUtil.resetCompanyId(orderMain);
        return orderMainMapper.selectOrderMainList(orderMain);
    }

    /**
     * 新增订单/任务主
     * 
     * @param orderMain 订单/任务主
     * @return 结果
     */
    @Transactional
    @Override
    public int insertOrderMain(OrderMain orderMain)
    {
        orderMain.setCreateTime(DateUtils.getNowDate());
        CommentUtil.resetCompanyId(orderMain);
        // 如果没有设置订单编号，则自动生成
        if (StringUtils.isEmpty(orderMain.getOrderCode())) {
            orderMainMapper.getOrderCode(orderMain);
            orderMain.setOrderCode(orderMain.getOrderCode());
        }
        int rows = orderMainMapper.insert(orderMain);
        insertOrderDetail(orderMain);
        return rows;
    }

    /**
     * 修改订单/任务主
     * 
     * @param orderMain 订单/任务主
     * @return 结果
     */
    @Transactional
    @Override
    public int updateOrderMain(OrderMain orderMain)
    {
        orderMain.setUpdateTime(DateUtils.getNowDate());
        orderMainMapper.deleteOrderDetailByOrderCode(orderMain.getId());
        insertOrderDetail(orderMain);
        return orderMainMapper.updateOrderMain(orderMain);
    }

    /**
     * 批量删除订单/任务主
     * 
     * @param ids 需要删除的订单/任务主主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteOrderMainByIds(Long[] ids)
    {
        orderMainMapper.deleteOrderDetailByOrderCodes(ids);
        return orderMainMapper.deleteOrderMainByIds(ids);
    }

    /**
     * 删除订单/任务主信息
     * 
     * @param id 订单/任务主主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteOrderMainById(Long id)
    {
        orderMainMapper.deleteOrderDetailByOrderCode(id);
        return orderMainMapper.deleteOrderMainById(id);
    }

    /**
     * 获取订单编号
     * @return
     */
    @Override
    public String getOrderCode() {
        OrderMain orderMain=new OrderMain();
        orderMainMapper.getOrderCode(orderMain);
        return orderMain.getOrderCode();
    }

    /**
     * 新增订单/任务详情信息
     * 
     * @param orderMain 订单/任务主对象
     */
    public void insertOrderDetail(OrderMain orderMain)
    {
        List<OrderDetail> orderDetailList = orderMain.getOrderDetailList();
        String orderCode = orderMain.getOrderCode();
        if (StringUtils.isNotNull(orderDetailList))
        {
            List<OrderDetail> list = new ArrayList<OrderDetail>();
            for (OrderDetail orderDetail : orderDetailList)
            {
                orderDetail.setOrderCode(orderCode);
                list.add(orderDetail);
            }
            if (list.size() > 0)
            {
                orderDetailService.saveBatch(list);
            }
        }
    }

    /**
     * 根据年份获取运营数据的接口
     * @return 运营数据值对象
     */
    @Override
    public OperationDataVO getOperationDataByYear(OrderMain orderMain) {
        CommentUtil.resetCompanyId(orderMain);
        return orderMainMapper.getOperationDataByYear(orderMain);
    }

    /**
     * 根据年份和月份获取生产统计数据
     * @return 运营数据值对象
     */
    @Override
    public OperationDataVO getOpDataByOrder(OrderMain orderMain) {
        if(orderMain.getCompanyId()==null){
            CommentUtil.resetCompanyId(orderMain);
        }
        return orderMainMapper.getOpDataByOrder(orderMain);
    }

    /**
     * 根据传入的 OrderMain 对象，调用 OrderMainMapper 的方法从数据库中获取订单图表数据。
     *
     * @param orderMain
     * @return 包含订单图表数据的 OrderChartVO 对象，其中包含横坐标数据、实际生产数据和计划生产数据。
     */
    @Override
    public OrderChartVO getOrderChartData(OrderMain orderMain) {
        CommentUtil.resetCompanyIdIfNull(orderMain);
        List<OrderChartVO> orderChartVOs = orderMainMapper.getOrderChartData(orderMain);
        OrderChartVO response = new OrderChartVO();
        for (OrderChartVO orderChartVO : orderChartVOs) {
            response.getActualProductionData().add(orderChartVO.getActualProduction());
            response.getPlannedProductionData().add(orderChartVO.getPlannedProduction());
            response.getXAxisData().add(orderChartVO.getOrderDate());
        }
        return response;
    }

    /**
     * 生产管理-生产计划-获取订单详情
     * @param orderMain
     * @return
     */
    @Override
    public OrderMain getOrderDetails(OrderMain orderMain){
        OrderMain main = orderMainMapper.getOrderMainByCode(orderMain);
        List<OrderDetail> orderDetailList = orderDetailService.list(new QueryWrapper<OrderDetail>().lambda().eq(OrderDetail::getOrderCode, orderMain.getOrderCode()));
        main.setOrderDetailList(orderDetailList);
        return main;
    }

    /**
     * 根据订单主表信息获取用于生产趋势分析图表的数据。
     *
     * @param orderMain
     * @return 生产趋势分析图表数据值对象，包含横坐标数据、实际生产数据和计划生产数据。
     */
    @Override
    public OrderChartVO getProductionTrend(OrderMain orderMain) {
        CommentUtil.resetCompanyIdIfNull(orderMain);
        List<OrderChartVO> orderChartVOs = orderMainMapper.getProductionTrend(orderMain);
        OrderChartVO response = new OrderChartVO();
        for (OrderChartVO orderChartVO : orderChartVOs) {
            response.getActualProductionData().add(orderChartVO.getActualProduction());
            response.getPlannedProductionData().add(orderChartVO.getPlannedProduction());
            response.getXAxisData().add(orderChartVO.getOrderDate());
        }
        return response;
    }

    

}
