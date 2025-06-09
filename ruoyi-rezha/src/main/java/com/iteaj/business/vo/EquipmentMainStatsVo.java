package com.iteaj.business.vo;

import com.iteaj.business.domain.EquipmentMaintRec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 维护统计信息VO，用于统计不同类型的维护次数
 *
 * @author qiancheng
 * @date 2025-03-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentMainStatsVo {
    /**
     * 设备例检次数
     */
    private int inspectionCount;
    /**
     * 故障暂停次数
     */
    private int faultPauseCount;
    /**
     * 维修记录列表
     */
    List<EquipmentMaintRec> equipmentMaintRecList;
}
