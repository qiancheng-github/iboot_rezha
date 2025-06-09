package com.ruoyi.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 公共工具类
 *
 * @author qiancheng
 * @date 2025-03-05
 */
@Component
public class CommentUtil {
    private static long companyId;

    @Value("${company_id}")
    public void setCompanyId(long value) {
        companyId = value;
    }

    /**
     * 初始化工厂ID
     * @param object
     * @param <T>
     * @author qiancheng
     * @since 2025-03-06
     */
    public static <T> void resetCompanyId(T object) {
        try {
            Method setCompanyId = object.getClass().getMethod("setCompanyId", Long.class);
            setCompanyId.invoke(object, companyId);
        } catch (Exception e) {
            throw new RuntimeException("设置companyId失败", e);
        }
    }

   /**
     * 判断并初始化工厂ID
     * @param object
     * @param <T>
     * @author qiancheng
     * @since 2025-03-11
     */
    public static <T> void resetCompanyIdIfNull(T object) {
        try {
            // 尝试获取对象的getCompanyId方法
            Method getCompanyIdMethod = object.getClass().getMethod("getCompanyId");
            // 调用getCompanyId方法获取当前对象的companyId值
            Long currentCompanyId = (Long) getCompanyIdMethod.invoke(object);
            // 判断当前对象的companyId值是否为null，若为null才进行赋值
            if (currentCompanyId == null) {
                resetCompanyId(object);
            }
        } catch (Exception e) {
            throw new RuntimeException("设置companyId失败", e);
        }
    }


}
