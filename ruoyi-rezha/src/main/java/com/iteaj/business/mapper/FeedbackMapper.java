package com.iteaj.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iteaj.business.domain.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 意见反馈Mapper接口
 * 
 * @author qiancheng
 * @date 2025-03-04
 */
@Mapper
public interface FeedbackMapper extends BaseMapper<Feedback>
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
     * 删除意见反馈
     * 
     * @param id 意见反馈主键
     * @return 结果
     */
    public int deleteFeedbackById(@Param("id")Long id);

    /**
     * 批量删除意见反馈
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFeedbackByIds(@Param("ids") Long[] ids);
}
