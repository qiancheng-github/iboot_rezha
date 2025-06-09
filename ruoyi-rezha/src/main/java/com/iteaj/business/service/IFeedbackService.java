package com.iteaj.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iteaj.business.domain.Feedback;

import java.util.List;


/**
 * 意见反馈Service接口
 * 
 * @author qiancheng
 * @date 2025-03-04
 */
public interface IFeedbackService extends IService<Feedback>
{
    /**
     * 查询意见反馈
     * 
     * @param id 意见反馈主键
     * @return 意见反馈
     */
    public Feedback selectFeedbackById(Long id);

    /**
     * 查询意见反馈列表
     * 
     * @param feedback 意见反馈
     * @return 意见反馈集合
     */
    public List<Feedback> selectFeedbackList(Feedback feedback);

    /**
     * 新增意见反馈
     * 
     * @param feedback 意见反馈
     * @return 结果
     */
    public int insertFeedback(Feedback feedback);

    /**
     * 修改意见反馈
     * 
     * @param feedback 意见反馈
     * @return 结果
     */
    public int updateFeedback(Feedback feedback);

    /**
     * 批量删除意见反馈
     * 
     * @param ids 需要删除的意见反馈主键集合
     * @return 结果
     */
    public int deleteFeedbackByIds(Long[] ids);

    /**
     * 删除意见反馈信息
     * 
     * @param id 意见反馈主键
     * @return 结果
     */
    public int deleteFeedbackById(Long id);
}
