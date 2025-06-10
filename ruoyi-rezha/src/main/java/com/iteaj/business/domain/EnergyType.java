package com.iteaj.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.iteaj.common.annotation.Excel;


import com.iteaj.framework.BaseEntity;
import com.iteaj.framework.TreeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 能源类型对象 energy_type
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("energy_type")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class EnergyType extends BaseEntity
{
    private static final long serialVersionUID = 1L;



    /** 工厂id */
    @Excel(name = "工厂id")
    @TableField(value = "company_id")
    private Long companyId;

    /** 能源名称 */
    @Excel(name = "能源名称")
    @TableField(value = "energy_name")
    private String energyName;

    /** 能源单位，如m³/t */
    @Excel(name = "能源单位，如m³/t")
    @TableField(value = "energy_unit")
    private String energyUnit;



}
