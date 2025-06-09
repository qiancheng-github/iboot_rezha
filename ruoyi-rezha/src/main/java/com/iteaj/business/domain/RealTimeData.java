package com.iteaj.business.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.iteaj.business.core.domain.BaseEntity;

/**
 * 实时数据对象 real_time_data
 * 
 * @author ldkj
 * @date 2025-02-26
 */
public class RealTimeData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 变量ID，自增主键 */
    private Long variableId;

    /** 数据ID */
    private Long dataId;

    /** 工厂id */
    //@Excel(name = "工厂id")
    private Long companyId;

    /** 关联的设备参数ID */
    //@Excel(name = "关联的设备参数ID")
    private Long parameterId;

    /** 工厂名称 */
    //@Excel(name = "工厂名称")
    private Long companyName;

    /** 参数值 */
    //@Excel(name = "参数值")
    private Long value;

    /** 关联的设备类型ID，外键指向equipment_types表 */
    //@Excel(name = "关联的设备类型ID，外键指向equipment_types表")
    private Long mainEquipmentTypeId;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collectTime;

    /** 主设备类型 */
    //@Excel(name = "主设备类型")
    private String mainEquipmentTypeName;

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

    public void setVariableId(Long variableId) 
    {
        this.variableId = variableId;
    }

    public Long getVariableId() 
    {
        return variableId;
    }
    public void setDataId(Long dataId) 
    {
        this.dataId = dataId;
    }

    public Long getDataId() 
    {
        return dataId;
    }
    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }
    public void setParameterId(Long parameterId) 
    {
        this.parameterId = parameterId;
    }

    public Long getParameterId() 
    {
        return parameterId;
    }
    public void setCompanyName(Long companyName) 
    {
        this.companyName = companyName;
    }

    public Long getCompanyName() 
    {
        return companyName;
    }
    public void setValue(Long value) 
    {
        this.value = value;
    }

    public Long getValue() 
    {
        return value;
    }
    public void setMainEquipmentTypeId(Long mainEquipmentTypeId) 
    {
        this.mainEquipmentTypeId = mainEquipmentTypeId;
    }

    public Long getMainEquipmentTypeId() 
    {
        return mainEquipmentTypeId;
    }
    public void setCollectTime(Date collectTime) 
    {
        this.collectTime = collectTime;
    }

    public Date getCollectTime() 
    {
        return collectTime;
    }
    public void setMainEquipmentTypeName(String mainEquipmentTypeName) 
    {
        this.mainEquipmentTypeName = mainEquipmentTypeName;
    }

    public String getMainEquipmentTypeName() 
    {
        return mainEquipmentTypeName;
    }
    public void setSecondaryEquipmentTypeId(Long secondaryEquipmentTypeId) 
    {
        this.secondaryEquipmentTypeId = secondaryEquipmentTypeId;
    }

    public Long getSecondaryEquipmentTypeId() 
    {
        return secondaryEquipmentTypeId;
    }
    public void setSecondaryEquipmentTypeName(String secondaryEquipmentTypeName) 
    {
        this.secondaryEquipmentTypeName = secondaryEquipmentTypeName;
    }

    public String getSecondaryEquipmentTypeName() 
    {
        return secondaryEquipmentTypeName;
    }
    public void setVariableName(String variableName) 
    {
        this.variableName = variableName;
    }

    public String getVariableName() 
    {
        return variableName;
    }
    public void setVariableEnName(String variableEnName) 
    {
        this.variableEnName = variableEnName;
    }

    public String getVariableEnName() 
    {
        return variableEnName;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setValueSource(String valueSource) 
    {
        this.valueSource = valueSource;
    }

    public String getValueSource() 
    {
        return valueSource;
    }
    public void setVariableValue(String variableValue) 
    {
        this.variableValue = variableValue;
    }

    public String getVariableValue() 
    {
        return variableValue;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setMinValue(BigDecimal minValue) 
    {
        this.minValue = minValue;
    }

    public BigDecimal getMinValue() 
    {
        return minValue;
    }
    public void setMaxValue(BigDecimal maxValue) 
    {
        this.maxValue = maxValue;
    }

    public BigDecimal getMaxValue() 
    {
        return maxValue;
    }
    public void setUpdateTimestamp(Date updateTimestamp) 
    {
        this.updateTimestamp = updateTimestamp;
    }

    public Date getUpdateTimestamp() 
    {
        return updateTimestamp;
    }
    public void setAccuracy(BigDecimal accuracy) 
    {
        this.accuracy = accuracy;
    }

    public BigDecimal getAccuracy() 
    {
        return accuracy;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("variableId", getVariableId())
            .append("dataId", getDataId())
            .append("companyId", getCompanyId())
            .append("parameterId", getParameterId())
            .append("companyName", getCompanyName())
            .append("value", getValue())
            .append("mainEquipmentTypeId", getMainEquipmentTypeId())
            .append("collectTime", getCollectTime())
            .append("mainEquipmentTypeName", getMainEquipmentTypeName())
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
