package com.iteaj.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.iteaj.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 能源监控对象 monitoring_energy
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("monitoring_energy")
public class MonitoringEnergy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 能源记录ID */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 工厂id */
    //@Excel(name = "工厂id")
    @TableField(value = "company_id")
    private Long companyId;

    /** 关联的订单编号 */
    //@Excel(name = "关联的订单编号")
    @TableField(value = "order_code")
    private String orderCode;

    /** 记录年份 */
    //@Excel(name = "记录年份")
    @TableField(value = "record_year")
    private Long recordYear;

    /** 记录月份 */
    //@Excel(name = "记录月份")
    @TableField(value = "record_month")
    private Long recordMonth;

    /** 记录日 */
    //@Excel(name = "记录日")
    @TableField(value = "record_day")
    private Long recordDay;

    /** 能源类型id */
    //@Excel(name = "能源类型id")
    @TableField(value = "energy_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long energyId;

    /** 能源名称 */
    //@Excel(name = "能源名称")
    @TableField(exist = false)
    private String energyName;

    /** 能源使用量 */
    //@Excel(name = "能源使用量")
    @TableField(value = "energy_usage")
    private BigDecimal energyUsage;

    /** 小时 */
    //@Excel(name = "小时")
    @TableField(exist = false)
    private int hour;

    /** 钢种规格，如20mm、18mm等 */
    //@Excel(name = "钢种规格，如20mm、18mm等")
    @TableField(exist = false)
    private String steelSpec;

}
