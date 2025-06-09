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

import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT;

/**
 * 意见反馈对象 feedback
 * 
 * @author qiancheng
 * @date 2025-03-04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("feedback")
public class Feedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id,自动递增 */
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 工厂id */
    //@Excel(name = "工厂id")
    @TableField(value="company_id",fill = INSERT)
    public Long companyId;

    /** 意见类型表：1:设备故障, 2:信息不准确, 3:人员排班信息有误, 4:其他 */
    //@Excel(name = "意见类型表：1:设备故障, 2:信息不准确, 3:人员排班信息有误, 4:其他")
    @TableField("feedback_type")
    private String feedbackType;

    /** 补充说明 */
    //@Excel(name = "补充说明")
    @TableField("supplementary_info")
    private String supplementaryInfo;

}
