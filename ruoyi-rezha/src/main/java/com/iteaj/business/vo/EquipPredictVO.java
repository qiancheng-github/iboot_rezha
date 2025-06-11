package com.iteaj.business.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设备预测VO
 *
 * @author qiancheng
 * @date 2025-04-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipPredictVO {
    /** 预测更换数量 */
    Integer changeCount;
    /** 损耗异常数量 */
    Integer abnormalCount;
    /** 故障率（百分比，0.23%） */
    Double faultRate;
}
