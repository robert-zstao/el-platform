package com.zst.el.logger;

import java.lang.annotation.*;

/**
 * 登录日志注解记录
 * @author robert
 * @date 2021/4/14 18:24
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented
public @interface LoginLog {
    char type() default '0';  // 操作类型
    String code() default ""; //操作状态
    String desc() default "";  // 操作说明
}
