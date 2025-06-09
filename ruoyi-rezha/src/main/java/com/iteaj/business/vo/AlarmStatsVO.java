package com.iteaj.business.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于封装设备安全预警统计信息的VO
 *
 * @author qiancheng
 * @date 2025-03-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlarmStatsVO {
    //预警总数
    private int total;
    // 紧急预警数量
    private int urgentCount;
    // 中等预警数量
    private int mediumCount;
    // 一般预警数量
    private int generalCount;
}
