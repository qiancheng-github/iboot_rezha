package com.iteaj.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.iteaj.business.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单/任务主对象 order_main
 * 
 * @author qiancheng
 * @date 2025-03-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("order_main")
public class OrderMain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 统计记录ID，唯一标识一条记录 */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 工厂id */
    //@Excel(name = "工厂id")
    @TableField(value = "company_id")
    private Long companyId;

    /** 订单编号/任务编号 */
    //@Excel(name = "订单编号/任务编号")
    @TableField(value = "order_code")
    private String orderCode;

    /** 订单年份 */
    //@Excel(name = "订单年份")
    @TableField(value = "order_year")
    private Long orderYear;

    /** 订单月份 */
    //@Excel(name = "订单月份")
    @TableField(value = "order_month")
    private Long orderMonth;

    /** 计划质量/t */
    //@Excel(name = "计划质量/t")
    @TableField(value = "planned_production")
    private BigDecimal plannedProduction;

    /** 当前质量/t */
    //@Excel(name = "当前质量/t")
    @TableField(value = "current_output")
    private BigDecimal currentOutput;

    /** 钢种规格，如20mm、18mm等 */
    //@Excel(name = "钢种规格，如20mm、18mm等")
    @TableField(value = "steel_spec")
    private String steelSpec;

    /** 成材率 */
    //@Excel(name = "成材率")
    @TableField(value = "yield_rate")
    private BigDecimal yieldRate;

    /** 热装率 */
    //@Excel(name = "热装率")
    @TableField(value = "hot_charging_rate")
    private BigDecimal hotChargingRate;

    /** 废品率 */
    //@Excel(name = "废品率")
    @TableField(value = "scrap_rate")
    private BigDecimal scrapRate;

    /** 库存率 */
    //@Excel(name = "库存率")
    @TableField(value = "inventory_rate")
    private BigDecimal inventoryRate;

    /** 订单状态 1:未开始 2:进行中 3:已完成 */
    //@Excel(name = "订单状态 1:未开始 2:进行中 3:已完成")
    @TableField(value = "order_status")
    private String orderStatus;

    /** 预计完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "预计完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    @TableField(value = "est_comp_time")
    private Date estCompTime;

    /** 订单/任务详情信息 */
    @TableField(exist = false)
    private List<OrderDetail> orderDetailList;

}
