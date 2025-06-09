package com.iteaj.business.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设备总览VO
 *
 * @author qiancheng
 * @date 2025-03-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentOverviewVo {
    // 设备总数
    private int totalCount;
    // 运行设备数
    private int runningCount;
    // 空闲设备数
    private int idleCount;
    // 维修设备数
    private int maintenanceCount;
}
