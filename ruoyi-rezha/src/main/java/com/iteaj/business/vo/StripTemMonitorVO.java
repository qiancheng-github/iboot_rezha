package com.iteaj.business.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 带钢温度监控VO
 *
 * @author qiancheng
 * @date 2025-04-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StripTemMonitorVO {
    /** 电磁感应入口温度（单位：℃） */
    private Double inductionEntryTemp;

    /** 电磁感应出口温度（单位：℃） */
    private Double inductionExitTemp;

    public StripTemMonitorVO(List<Double> values) {
        this.inductionEntryTemp = values.get(0);
        this.inductionExitTemp = values.get(1);
    }

}
