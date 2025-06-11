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
 * 订单/任务详情对象 order_detail
 * 
 * @author qiancheng
 * @date 2025-03-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("order_detail")
public class OrderDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 订单编号/任务编号 */
    //@Excel(name = "订单编号/任务编号")
    @TableField(value = "order_code")
    private String orderCode;

    /** 当前质量/t */
    //@Excel(name = "当前质量/t")
    @TableField(value = "total_quantity")
    private BigDecimal totalQuantity;

    /** 生产日/天 */
    //@Excel(name = "生产日/天")
    @TableField(value = "production_day")
    private Long productionDay;

    /** 是否废品：0:否，1:是 */
    //@Excel(name = "是否废品：0:否，1:是")
    @TableField(value = "is_scrap")
    private String isScrap;

    /** 钢坯编号 */
    //@Excel(name = "钢坯编号")
    @TableField(value = "billet_code")
    private String billetCode;

    /** 备用字段1 */
    //@Excel(name = "备用字段1")
    @TableField(value = "spare_field1")
    private String spareField1;

    /** 备用字段2 */
    //@Excel(name = "备用字段2")
    @TableField(value = "spare_field2")
    private String spareField2;


}
