package com.iteaj.business.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 首页订单、生产计划图表数据值VO，用于封装生产统计所需的数据
 *
 * @author qiancheng
 * @date 2025-03-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeriesDataVo {
    //折线Y轴名称
    private String name;
    //Y轴对应数据
    private List<Double> data;
}
