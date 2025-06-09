package com.iteaj.business.controller;

import com.iteaj.business.domain.Feedback;
import com.iteaj.business.service.IFeedbackService;
import com.iteaj.business.annotation.Anonymous;
import com.iteaj.business.annotation.Log;
import com.iteaj.business.core.controller.BaseController;
import com.iteaj.business.core.domain.AjaxResult;
import com.iteaj.business.core.page.TableDataInfo;
import com.iteaj.business.enums.BusinessType;
import com.iteaj.business.utils.poi.ExcelUtil;
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
    public TableDataInfo list(Feedback feedback)
    {
        startPage();
        List<Feedback> list = feedbackService.selectFeedbackList(feedback);
        return getDataTable(list);
    }

    /**
     * 导出意见反馈列表
     */
    //@PreAuthorize("@ss.hasPermi('system:feedback:export')")
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
    //@PreAuthorize("@ss.hasPermi('system:feedback:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") long id)
    {
        return success(feedbackService.selectFeedbackById(id));
    }

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
    //@PreAuthorize("@ss.hasPermi('system:feedback:edit')")
    @Log(title = "意见反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Feedback feedback)
    {
        return toAjax(feedbackService.updateFeedback(feedback));
    }

    /**
     * 删除意见反馈
     */
    //@PreAuthorize("@ss.hasPermi('system:feedback:remove')")
    @Log(title = "意见反馈", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable("ids") Long[] ids)
    {
        return toAjax(feedbackService.deleteFeedbackByIds(ids));
    }
}
