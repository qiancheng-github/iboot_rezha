package com.iteaj.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.iteaj.business.core.domain.BaseEntity;

/**
 * 历史数据对象 historical_data
 * 
 * @author ldkj
 * @date 2025-02-26
 */
public class HistoricalData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据ID */
    private Long dataId;

    /** 关联的设备参数ID */
    //@Excel(name = "关联的设备参数ID")
    private Long parameterId;

    /** 参数值 */
    //@Excel(name = "参数值")
    private Long value;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collectTime;

    /** 数据质量（OPC标准） */
    //@Excel(name = "数据质量", readConverterExp = "O=PC标准")
    private Long quality;

    public void setDataId(Long dataId) 
    {
        this.dataId = dataId;
    }

    public Long getDataId() 
    {
        return dataId;
    }
    public void setParameterId(Long parameterId) 
    {
        this.parameterId = parameterId;
    }

    public Long getParameterId() 
    {
        return parameterId;
    }
    public void setValue(Long value) 
    {
        this.value = value;
    }

    public Long getValue() 
    {
        return value;
    }
    public void setCollectTime(Date collectTime) 
    {
        this.collectTime = collectTime;
    }

    public Date getCollectTime() 
    {
        return collectTime;
    }
    public void setQuality(Long quality) 
    {
        this.quality = quality;
    }

    public Long getQuality() 
    {
        return quality;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dataId", getDataId())
            .append("parameterId", getParameterId())
            .append("value", getValue())
            .append("collectTime", getCollectTime())
            .append("quality", getQuality())
            .toString();
    }
}
