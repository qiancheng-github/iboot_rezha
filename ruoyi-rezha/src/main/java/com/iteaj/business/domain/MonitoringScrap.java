package com.iteaj.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.iteaj.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 废品监控对象 monitoring_scrap
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("monitoring_scrap")
public class MonitoringScrap extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 废品记录ID */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 工厂id */
    //@Excel(name = "工厂id")
    @TableField(value = "company_id")
    private Long companyId;

    /** 订单ID */
    //@Excel(name = "订单ID")
    @TableField(value = "order_id")
    private Long orderId;

    /** 关联的订单详情ID */
    //@Excel(name = "关联的订单详情ID")
    @TableField(value = "detail_id")
    private Long detailId;

    /** 设备类型ID */
    //@Excel(name = "设备类型ID")
    @TableField(value = "equipment_type_id")
    private Long equipmentTypeId;

    /** 设备名称 */
    //@Excel(name = "设备名称")
    @TableField(value = "equipment_type_name")
    private String equipmentTypeName;

    /** 废品原因 */
    //@Excel(name = "废品原因")
    @TableField(value = "scrap_reason")
    private String scrapReason;

    /** 废品开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "废品开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    @TableField(value = "scrap_start_time")
    private Date scrapStartTime;

    /** 废品结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "废品结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    @TableField(value = "scrap_end_time")
    private Date scrapEndTime;


}
