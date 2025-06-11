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

/**
 * 监控_设备预警对象 monitoring_equip_alarm
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("monitoring_equip_alarm")
public class MonitoringEquipAlarm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 工厂id */
    //@Excel(name = "工厂id")
    @TableField(value = "company_id")
    private Long companyId;

    /** 设备类型ID */
    //@Excel(name = "设备类型ID")
    @TableField(value = "equipment_type_id")
    private Long equipmentTypeId;

    /** 故障名称 */
    //@Excel(name = "故障名称")
    @TableField(value = "failure_name")
    private String failureName;

    /** 设备预警类型 */
    //@Excel(name = "设备预警类型")
    @TableField(value = "alarm_type")
    private String alarmType;

    /** 设备预警危险等级，1:紧急，2:中等，3:一般 */
    //@Excel(name = "设备预警危险等级，1:紧急，2:中等，3:一般")
    @TableField(value = "danger_level")
    private String dangerLevel;

    /** 设备详细位置 */
    //@Excel(name = "设备详细位置")
    @TableField(value = "location")
    private String location;

    /** 检测年份 */
    //@Excel(name = "检测年份")
    @TableField(value = "alarm_year")
    private Long alarmYear;

    /** 检测月份 */
    //@Excel(name = "检测月份")
    @TableField(value = "alarm_month")
    private Long alarmMonth;

    /** 响应措施 */
    //@Excel(name = "响应措施")
    @TableField(value = "response_measures")
    private String responseMeasures;

    /** 设备预警内容 */
    //@Excel(name = "设备预警内容")
    @TableField(value = "eqp_warn_cont")
    private String eqpWarnCont;

    /** 预警主分类：1:监控预警，2:安全预警 */
    //@Excel(name = "预警主分类：1:监控预警，2:安全预警")
    @TableField(value = "war_main_cat")
    private String warMainCat;

    /** 监控缩略图 */
    //@Excel(name = "监控缩略图")
    @TableField(value = "mon_thumb")
    private String monThumb;


}
