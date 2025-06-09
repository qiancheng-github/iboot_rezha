package com.iteaj.business.service.impl;

import com.iteaj.business.domain.EquipmentVariables;
import com.iteaj.business.mapper.EquipmentVariablesMapper;
import com.iteaj.business.service.IEquipmentVariablesService;
import com.iteaj.business.vo.StripTemMonitorVO;
import com.iteaj.business.utils.CommentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 存储设备变量参数信息的Service业务层处理
 * 
 * @author ldkj
 * @date 2025-02-27
 */
@Service
public class EquipmentVariablesServiceImpl implements IEquipmentVariablesService 
{
    @Autowired
    private EquipmentVariablesMapper equipmentVariablesMapper;

    /**
     * 查询存储设备变量参数信息的
     * 
     * @param variableId 存储设备变量参数信息的主键
     * @return 存储设备变量参数信息的
     */
    @Override
    public EquipmentVariables selectEquipmentVariablesByVariableId(Long variableId)
    {
        return equipmentVariablesMapper.selectEquipmentVariablesByVariableId(variableId);
    }

    /**
     * 查询存储设备变量参数信息的列表
     * 
     * @param equipmentVariables 存储设备变量参数信息的
     * @return 存储设备变量参数信息的
     */
    @Override
    public List<EquipmentVariables> selectEquipmentVariablesList(EquipmentVariables equipmentVariables)
    {
        return equipmentVariablesMapper.selectEquipmentVariablesList(equipmentVariables);
    }

    /**
     * 新增存储设备变量参数信息的
     * 
     * @param equipmentVariables 存储设备变量参数信息的
     * @return 结果
     */
    @Override
    public int insertEquipmentVariables(EquipmentVariables equipmentVariables)
    {
        return equipmentVariablesMapper.insertEquipmentVariables(equipmentVariables);
    }

    /**
     * 修改存储设备变量参数信息的
     * 
     * @param equipmentVariables 存储设备变量参数信息的
     * @return 结果
     */
    @Override
    public int updateEquipmentVariables(EquipmentVariables equipmentVariables)
    {

        return equipmentVariablesMapper.updateEquipmentVariables(equipmentVariables);
    }

    /**
     * 批量删除存储设备变量参数信息的
     * 
     * @param variableIds 需要删除的存储设备变量参数信息的主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentVariablesByVariableIds(Long[] variableIds)
    {
        return equipmentVariablesMapper.deleteEquipmentVariablesByVariableIds(variableIds);
    }

    /**
     * 删除存储设备变量参数信息的信息
     * 
     * @param variableId 存储设备变量参数信息的主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentVariablesByVariableId(Long variableId)
    {
        return equipmentVariablesMapper.deleteEquipmentVariablesByVariableId(variableId);
    }

    /**
     * 生产管理->>带钢温度监控->>获取电磁感应入口温度
     * @param equipmentVariables
     * @return
     */
    @Override
    public StripTemMonitorVO getStrpTempVo(EquipmentVariables equipmentVariables) {
        CommentUtil.resetCompanyId(equipmentVariables);
        List<EquipmentVariables> strpTempVo = equipmentVariablesMapper.getStrpTempVo(equipmentVariables);
        List<Double> valueList = strpTempVo.stream()
                .map(EquipmentVariables::getVariableValue)
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toList());
        return new StripTemMonitorVO(valueList);
    }

    /**
     * 生产管理->>激光扫描->>获取激光扫描结果
     * @param equipmentVariables
     * @return
     */
    @Override
    public List<String> getLaserScanResult(EquipmentVariables equipmentVariables) {
        List<String> result = new ArrayList<>();
        List<String> files=new ArrayList<String>(){{add("/root/rezha/base64.txt");add("/root/rezha/base641.txt");}};
        for (String file : files) {
            StringBuilder append = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    append.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            result.add(append.toString());
        }
        return result;

    }

}
