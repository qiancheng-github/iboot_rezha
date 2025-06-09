package com.iteaj.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.iteaj.business.core.domain.TreeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 存储设备类型信息的，支持树状结构对象 equipment_types
 * 
 * @author ldkj
 * @date 2025-03-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("equipment_types")
public class EquipmentTypes extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备类型ID，自增主键 */
    @TableId(value = "equipment_type_id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long equipmentTypeId;

    /** 父级设备类型ID，NULL表示顶级类型 */
    //@Excel(name = "父级设备类型ID，NULL表示顶级类型")
    @TableField(value = "parent_equipment_type_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentEquipmentTypeId;

    /** 设备类型名称，不能为空 */
    //@Excel(name = "设备类型名称，不能为空")
    @TableField(value = "equipment_type_name")
    private String equipmentTypeName;

    /** 设备类型描述 */
    //@Excel(name = "设备类型描述")
    @TableField(value = "description")
    private String description;

    /** 设备制造商 */
    //@Excel(name = "设备制造商")
    @TableField(value = "manufacturer")
    private String manufacturer;

    /** 设备安装日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "设备安装日期", width = 30, dateFormat = "yyyy-MM-dd")
    @TableField(value = "installation_date")
    private Date installationDate;

    /** 设备维护状态 */
    //@Excel(name = "设备维护状态")
    @TableField(value = "maintenance_status")
    private String maintenanceStatus;

    /** 质保期（月） */
    //@Excel(name = "质保期", readConverterExp = "月=")
    @TableField(value = "warranty_period")
    private Long warrantyPeriod;

    /** 设备位置 */
    //@Excel(name = "设备位置")
    @TableField(value = "location")
    private String location;

    /** 运行状态 1:运行 2:空闲 3:维修 */
    //@Excel(name = "运行状态 1:运行 2:空闲 3:维修")
    @TableField(value = "operation_status")
    private String operationStatus;

    /** 使用时长 */
    //@Excel(name = "使用时长")
    @TableField(value = "usage_duration")
    private BigDecimal usageDuration;

    /** 使用次数 */
    //@Excel(name = "使用次数")
    @TableField(value = "usage_count")
    private Long usageCount;

    /** 预计使用时长 */
    //@Excel(name = "预计使用时长")
    @TableField(value = "exp_usage_dur")
    private BigDecimal expUsageDur;

    /** 预计使用次数 */
    //@Excel(name = "预计使用次数")
    @TableField(value = "exp_usage_count")
    private Long expUsageCount;

    /** 磨损比例分析 */
    //@Excel(name = "磨损比例分析")
    @TableField(value = "wear_ratio_analysis")
    private BigDecimal wearRatioAnalysis;

    /** 剩余使用次数 */
    //@Excel(name = "剩余使用次数")
    @TableField(value = "rem_usage_count")
    private Long remUsageCount;

    /** 剩余使用时长 */
    //@Excel(name = "剩余使用时长")
    @TableField(value = "rem_usage_dur")
    private BigDecimal remUsageDur;


}
