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
 * 设备预测对象 equipment_pred
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("equipment_pred")
public class EquipmentPred extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预测记录ID */
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

    /** 是否更换 0:否 1:是 */
    //@Excel(name = "是否更换 0:否 1:是")
    @TableField(value = "is_replace")
    private String isReplace;

    /** 设备是否损耗 0:否 1:是
 */
    //@Excel(name = "设备是否损耗 0:否 1:是")
    @TableField(value = "is_lossy")
    private String isLossy;

    /** 设备是否故障  0:否 1:是 */
    //@Excel(name = "设备是否故障  0:否 1:是")
    @TableField(value = "is_rate")
    private String isRate;

    /** 设备使用时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "设备使用时间", width = 30, dateFormat = "yyyy-MM-dd")
    @TableField(value = "use_time")
    private Date useTime;

    /** 危险级别，1:轻微、2:严重、 3:一般 */
    //@Excel(name = "危险级别，1:轻微、2:严重、 3:一般")
    @TableField(value = "risk_level")
    private String riskLevel;


}
