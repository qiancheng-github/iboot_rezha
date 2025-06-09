package com.iteaj.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.iteaj.business.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 监控_视频对象 monitoring_video
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("monitoring_video")
public class MonitoringVideo extends BaseEntity
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

    /** 监控区域名称 */
    //@Excel(name = "监控区域名称")
    @TableField(value = "area_name")
    private String areaName;

    /** 摄像头地址 */
    //@Excel(name = "摄像头地址")
    @TableField(value = "video_link")
    private String videoLink;

    /** 视频缩略图地址 */
    //@Excel(name = "视频缩略图地址")
    @TableField(value = "thumbnail_link")
    private String thumbnailLink;


}
