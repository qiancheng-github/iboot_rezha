package com.iteaj.business.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设备预测信息VO
 *
 * @author qiancheng
 * @date 2025-04-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipPredictDetailVO {
    /** 设备名称 */
    private String name;
    /** 设备使用时间 */
    private String useTime;
    /** 危险级别 */
    private String riskLevel;
}
