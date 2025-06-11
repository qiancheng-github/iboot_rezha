package com.iteaj.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iteaj.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 存储设备变量参数信息的对象 equipment_variables
 * 
 * @author ldkj
 * @date 2025-02-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentVariables extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 变量ID，自增主键 */
    private Long variableId;

    /** 工厂id */
    //@Excel(name = "工厂id")
    private Long companyId;

    /** 工厂名称 */
    //@Excel(name = "工厂名称")
    private String companyName;

    /** 关联的设备类型ID，外键指向equipment_types表 */
//    //@Excel(name = "关联的设备类型ID，外键指向equipment_types表")
//    private Long mainEquipmentTypeId;

    /** 主设备类型 */
//    //@Excel(name = "主设备类型")
//    private String mainEquipmentTypeName;

    /** 关联的设备类型ID，外键指向equipment_types表 */
    //@Excel(name = "关联的设备类型ID，外键指向equipment_types表")
    private Long secondaryEquipmentTypeId;

    /** 次级设备类型 */
    //@Excel(name = "次级设备类型")
    private String secondaryEquipmentTypeName;

    /** 变量名称 */
    //@Excel(name = "变量名称")
    private String variableName;

    /** 变量英文名称 */
    //@Excel(name = "变量英文名称")
    private String variableEnName;

    /** 变量所属区域 */
    //@Excel(name = "变量所属区域")
    private String area;

    /** 变量来源 */
    //@Excel(name = "变量来源")
    private String valueSource;

    /** 变量当前值 */
    //@Excel(name = "变量当前值")
    private String variableValue;

    /** 变量描述 */
    //@Excel(name = "变量描述")
    private String description;

    /** 变量允许的最小值 */
    //@Excel(name = "变量允许的最小值")
    private BigDecimal minValue;

    /** 变量允许的最大值 */
    //@Excel(name = "变量允许的最大值")
    private BigDecimal maxValue;

    /** 变量最后更新时间戳 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "变量最后更新时间戳", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateTimestamp;

    /** 变量值的精度 */
    //@Excel(name = "变量值的精度")
    private BigDecimal accuracy;

    /** 变量值的单位 */
    //@Excel(name = "变量值的单位")
    private String unit;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("variableId", getVariableId())
            .append("companyId", getCompanyId())
            .append("companyName", getCompanyName())
            .append("secondaryEquipmentTypeId", getSecondaryEquipmentTypeId())
            .append("secondaryEquipmentTypeName", getSecondaryEquipmentTypeName())
            .append("variableName", getVariableName())
            .append("variableEnName", getVariableEnName())
            .append("area", getArea())
            .append("valueSource", getValueSource())
            .append("variableValue", getVariableValue())
            .append("description", getDescription())
            .append("minValue", getMinValue())
            .append("maxValue", getMaxValue())
            .append("updateTimestamp", getUpdateTimestamp())
            .append("accuracy", getAccuracy())
            .append("unit", getUnit())
            .toString();
    }
}
