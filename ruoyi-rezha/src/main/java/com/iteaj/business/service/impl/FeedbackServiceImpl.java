package com.iteaj.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iteaj.business.domain.Feedback;
import com.iteaj.business.mapper.FeedbackMapper;
import com.iteaj.business.service.IFeedbackService;
import com.iteaj.common.utils.CommentUtil;
import com.iteaj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 意见反馈Service业务层处理
 * 
 * @author qiancheng
 * @date 2025-03-04
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements IFeedbackService
{
    @Autowired
    private FeedbackMapper feedbackMapper;

    /**
     * 查询意见反馈
     * 
     * @param id 意见反馈主键
     * @return 意见反馈
     */
    @Override
    public Feedback selectFeedbackById(Long id)
    {
        return feedbackMapper.selectFeedbackById(id);
    }

    /**
     * 查询意见反馈列表
     * 
     * @param feedback 意见反馈
     * @return 意见反馈
     */
    @Override
    public List<Feedback> selectFeedbackList(Feedback feedback)
    {
        CommentUtil.resetCompanyId(feedback);
        return feedbackMapper.selectFeedbackList(feedback);
    }

    /**
     * 新增意见反馈
     * 
     * @param feedback 意见反馈
     * @return 结果
     */
    @Override
    public int insertFeedback(Feedback feedback)
    {
        feedback.setCreateTime(DateUtils.getNowDate());
        //设置工厂id
        CommentUtil.resetCompanyId(feedback);
        return feedbackMapper.insert(feedback);
    }

    /**
     * 修改意见反馈
     * 
     * @param feedback 意见反馈
     * @return 结果
     */
    @Override
    public int updateFeedback(Feedback feedback)
    {
        feedback.setUpdateTime(DateUtils.getNowDate());
        return feedbackMapper.updateFeedback(feedback);
    }

    /**
     * 批量删除意见反馈
     * 
     * @param ids 需要删除的意见反馈主键
     * @return 结果
     */
    @Override
    public int deleteFeedbackByIds(Long[] ids)
    {
        return feedbackMapper.deleteFeedbackByIds(ids);
    }

    /**
     * 删除意见反馈信息
     * 
     * @param id 意见反馈主键
     * @return 结果
     */
    @Override
    public int deleteFeedbackById(Long id)
    {
        return feedbackMapper.deleteFeedbackById(id);
    }
}
