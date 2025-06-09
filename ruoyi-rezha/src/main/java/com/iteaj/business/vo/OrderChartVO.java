package com.iteaj.business.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页订单、生产计划图表数据值VO，用于封装生产统计所需的数据
 *
 * @author qiancheng
 * @date 2025-03-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderChartVO {

    /**
     * 单个日期的实际生产数量
     */
    private Double actualProduction;

    /**
     * 单个日期的计划生产数量
     */
    private Double plannedProduction;

    /**
     * 单个日期值
     */
    private String orderDate;

    /**
     * 横坐标数据，通常为日期列表，与实际生产和计划生产数据一一对应。
     * 前端会使用该列表作为图表的横坐标标签。
     */
    private List<String> xAxisData = new ArrayList<>();

    /**
     * 实际生产数据列表，每个元素对应 xAxisData 中相同索引位置的日期的实际生产数量。
     * 该列表的数据将用于绘制图表中实际生产的线条。
     */
    private List<Double> actualProductionData = new ArrayList<>();

    /**
     * 计划生产数据列表，每个元素对应 xAxisData 中相同索引位置的日期的计划生产数量。
     * 该列表的数据将用于绘制图表中计划生产的线条。
     */
    private List<Double> plannedProductionData = new ArrayList<>();


}
