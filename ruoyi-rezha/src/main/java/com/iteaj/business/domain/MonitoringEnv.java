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

import java.math.BigDecimal;
import java.util.Date;

/**
 * 监控_环境对象 monitoring_env
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("monitoring_env")
public class MonitoringEnv extends BaseEntity
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

    /** 环境数据检测时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "环境数据检测时间", width = 30, dateFormat = "yyyy-MM-dd")
    @TableField(value = "monitor_time")
    private Date monitorTime;

    /** 检测地详细位置 */
    //@Excel(name = "检测地详细位置")
    @TableField(value = "location")
    private String location;

    /** 环境温度，单位℃ */
    //@Excel(name = "环境温度，单位℃")
    @TableField(value = "temperature")
    private BigDecimal temperature;

    /** 环境湿度，单位% */
    //@Excel(name = "环境湿度，单位%")
    @TableField(value = "humidity")
    private BigDecimal humidity;

}
