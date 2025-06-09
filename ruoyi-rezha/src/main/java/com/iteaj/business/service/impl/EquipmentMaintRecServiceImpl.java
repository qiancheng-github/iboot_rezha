package com.iteaj.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iteaj.business.domain.EquipmentMaintRec;
import com.iteaj.business.mapper.EquipmentMaintRecMapper;
import com.iteaj.business.service.IEquipmentMaintRecService;
import com.iteaj.business.vo.EquipmentMainStatsVo;
import com.ruoyi.common.constant.CommentConstants;
import com.iteaj.business.utils.CommentUtil;
import com.iteaj.business.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备维护记录Service业务层处理
 * 
 * @author qiancheng
 * @date 2025-03-06
 */
@Service
public class EquipmentMaintRecServiceImpl extends ServiceImpl<EquipmentMaintRecMapper, EquipmentMaintRec> implements IEquipmentMaintRecService
{
    @Autowired
    private EquipmentMaintRecMapper equipmentMaintRecMapper;

    /**
     * 查询设备维护记录
     * 
     * @param recordId 设备维护记录主键
     * @return 设备维护记录
     */
    @Override
    public EquipmentMaintRec selectEquipmentMaintRecByRecordId(Long recordId)
    {
        return equipmentMaintRecMapper.selectEquipmentMaintRecByRecordId(recordId);
    }

    /**
     * 查询设备维护记录列表
     * 
     * @param equipmentMaintRec 设备维护记录
     * @return 设备维护记录
     */
    @Override
    public List<EquipmentMaintRec> selectEquipmentMaintRecList(EquipmentMaintRec equipmentMaintRec)
    {
        return equipmentMaintRecMapper.selectEquipmentMaintRecList(equipmentMaintRec);
    }

    /**
     * 新增设备维护记录
     * 
     * @param equipmentMaintRec 设备维护记录
     * @return 结果
     */
    @Override
    public int insertEquipmentMaintRec(EquipmentMaintRec equipmentMaintRec)
    {
        equipmentMaintRec.setCreateTime(DateUtils.getNowDate());
        return equipmentMaintRecMapper.insertEquipmentMaintRec(equipmentMaintRec);
    }

    /**
     * 修改设备维护记录
     * 
     * @param equipmentMaintRec 设备维护记录
     * @return 结果
     */
    @Override
    public int updateEquipmentMaintRec(EquipmentMaintRec equipmentMaintRec)
    {
        equipmentMaintRec.setUpdateTime(DateUtils.getNowDate());
        return equipmentMaintRecMapper.updateEquipmentMaintRec(equipmentMaintRec);
    }

    /**
     * 批量删除设备维护记录
     * 
     * @param recordIds 需要删除的设备维护记录主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentMaintRecByRecordIds(Long[] recordIds)
    {
        return equipmentMaintRecMapper.deleteEquipmentMaintRecByRecordIds(recordIds);
    }

    /**
     * 删除设备维护记录信息
     * 
     * @param recordId 设备维护记录主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentMaintRecByRecordId(Long recordId)
    {
        return equipmentMaintRecMapper.deleteEquipmentMaintRecByRecordId(recordId);
    }

    /**
     * 设备维护记录_查询设备维护记录列表
     * @param equipmentMaintRec
     * @return
     */
    @Override
    public EquipmentMainStatsVo getMaintRecListByYear(EquipmentMaintRec equipmentMaintRec) {
        CommentUtil.resetCompanyIdIfNull(equipmentMaintRec);
        EquipmentMainStatsVo maintStatsByYear = baseMapper.getMaintStatsByYear(equipmentMaintRec);
        List<EquipmentMaintRec> equipmentMaintRecs = this.list(new QueryWrapper<EquipmentMaintRec>().lambda()
                .eq(EquipmentMaintRec::getRecordYear, equipmentMaintRec.getRecordYear())
                .eq(EquipmentMaintRec::getCompanyId, equipmentMaintRec.getCompanyId())
                .eq(EquipmentMaintRec::getDelFlag, CommentConstants.PUBLIC_NO)
                .orderByDesc(EquipmentMaintRec::getCreateTime));
        maintStatsByYear.setEquipmentMaintRecList(equipmentMaintRecs);
        return maintStatsByYear;
    }
    
}
