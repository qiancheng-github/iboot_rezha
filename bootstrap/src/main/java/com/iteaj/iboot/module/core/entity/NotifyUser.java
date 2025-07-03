package com.iteaj.iboot.module.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iteaj.framework.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 消息通知用户
 * </p>
 *
 * @author iteaj
 * @since 2023-09-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_notify_user")
public class NotifyUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 所属通知
     */
    private Long notifyId;

    /**
     * 已读状态(false未读 true已读)
     */
    private Boolean status;

    /**
     * 已读时间
     */
    private Date readTime;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;


}
