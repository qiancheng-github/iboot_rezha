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
 * 系统通知
 * </p>
 *
 * @author iteaj
 * @since 2023-08-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_notify")
public class Notify extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 消息标题
     */
    private String title;

    /**
     * 机构id
     */
    private Long createUser;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息类型
     */
    private String type;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;


}
