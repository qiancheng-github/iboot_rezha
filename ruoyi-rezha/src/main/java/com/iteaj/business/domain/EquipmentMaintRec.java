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

import java.util.Date;

/**
 * 设备维护记录对象 equipment_maint_rec
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("equipment_maint_rec")
public class EquipmentMaintRec extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 维护记录ID */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 工厂ID */
    //@Excel(name = "工厂ID")
    @TableField(value = "company_id")
    private Long companyId;

    /** 设备类型ID */
    //@Excel(name = "设备类型ID")
    @TableField(value = "equipment_type_id")
    private Long equipmentTypeId;

    /** 设备名称 */
    //@Excel(name = "设备名称")
    @TableField(value = "equipment_type_name")
    private String equipmentTypeName;

    /** 记录年份 */
    //@Excel(name = "记录年份")
    @TableField(value = "record_year")
    private Long recordYear;

    /** 记录月份 */
    //@Excel(name = "记录月份")
    @TableField(value = "record_month")
    private Long recordMonth;

    /** 记录日期 */
    //@Excel(name = "记录日期")
    @TableField(value = "record_day")
    private Long recordDay;

    /** 维护时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "维护时间", width = 30, dateFormat = "yyyy-MM-dd")
    @TableField(value = "maintenance_time")
    private Date maintenanceTime;

    /** 维修原因 */
    //@Excel(name = "维修原因")
    @TableField(value = "repair_reason")
    private String repairReason;

    /** 检修时长 */
    //@Excel(name = "检修时长")
    @TableField(value = "maintenance_duration")
    private String maintenanceDuration;

    /** 检修人员 */
    //@Excel(name = "检修人员")
    @TableField(value = "maintenance_staff")
    private String maintenanceStaff;


}
