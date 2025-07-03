package com.iteaj.business.controller;

import com.iteaj.business.domain.Feedback;
import com.iteaj.business.service.IFeedbackService;
import com.iteaj.common.annotation.Anonymous;
import com.iteaj.common.annotation.Log;
import com.iteaj.common.core.controller.BaseController;
import com.iteaj.common.core.domain.AjaxResult;
import com.iteaj.common.core.page.TableDataInfo;
import com.iteaj.common.enums.BusinessType;
import com.iteaj.common.utils.CommentUtil;
import com.iteaj.common.utils.poi.ExcelUtil;
import com.iteaj.framework.logger.Logger;
import com.iteaj.framework.result.Result;
import com.iteaj.framework.security.CheckPermission;
import com.iteaj.framework.security.Logical;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 意见反馈Controller
 * 
 * @author qiancheng
 * @date 2025-03-04
 */
@RestController
@RequestMapping("/system/feedback")
public class FeedbackController extends BaseController
{
    @Autowired
    private IFeedbackService feedbackService;

    /**
     * 查询意见反馈列表
     */
    @Anonymous
    @GetMapping("/list")
    public AjaxResult list(Feedback feedback)
    {
        startPage();
        List<Feedback> list = feedbackService.selectFeedbackList(feedback);
        return success(list);
    }

    /**
     * 导出意见反馈列表
     */
    
    @Log(title = "意见反馈", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Feedback feedback)
    {
        List<Feedback> list = feedbackService.selectFeedbackList(feedback);
        ExcelUtil<Feedback> util = new ExcelUtil<Feedback>(Feedback.class);
        util.exportExcel(response, list, "意见反馈数据");
    }

    /**
     * 获取意见反馈详细信息
     */
    
    @GetMapping(value = "/edit")
    public AjaxResult getInfo(long id)
    {
        return success(feedbackService.selectFeedbackById(id));
    }

    /**
     * 获取编辑记录
     * @param id 记录id
     */
//    @GetMapping("/edit")
//    @CheckPermission({"core:notify:edit"})
//    public Result<Notify> getById(Long id) {
//        return this.notifyService.getById(id);
//    }

    /**
     * 新增意见反馈
     */
    @Anonymous
    @Log(title = "意见反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Feedback feedback)
    {
        return toAjax(feedbackService.insertFeedback(feedback));
    }

    /**
     * 修改意见反馈
     */
    
    @Log(title = "意见反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Feedback feedback)
    {
        return toAjax(feedbackService.updateFeedback(feedback));
    }

    /**
     * 删除意见反馈
     */

    @Log(title = "意见反馈", businessType = BusinessType.DELETE)
	@PostMapping("/del")
    public AjaxResult remove(@RequestBody List<Long> idList)
    {
        Long[] ids = idList.toArray(new Long[0]);
        return toAjax(feedbackService.deleteFeedbackByIds(ids));
    }

    /**
     * 新增或者更新记录
     * @param feedback
     */
    @PostMapping("/saveOrUpdate")
    public AjaxResult saveOrUpdate(@RequestBody Feedback feedback) {
        //设置工厂id
        CommentUtil.resetCompanyId(feedback);
        return toAjax(this.feedbackService.saveOrUpdate(feedback));
    }
}
