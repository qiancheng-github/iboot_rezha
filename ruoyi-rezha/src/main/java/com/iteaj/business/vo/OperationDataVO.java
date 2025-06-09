package com.iteaj.business.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 运营数据值VO，用于封装按年份统计的运营数据
 *
 * @author qiancheng
 * @date 2025-03-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDataVO {
    /**
     * 总产量
     */
    private Double totalOutput;

    /**
     * 成材率
     */
    private Double yieldRate;

    /**
     * 废品率
     */
    private Double scrapRate;

    /**
     * 热装率
     */
    private Double hotChargingRate;

    /**
     * 库存率
     */
    private Double inventoryRate;

    /**
     * 当前产量
     */
    private Double currentOutput;

    /**
     * 计划生产
     */
    private Double plannedProduction;
}
