package com.zst.el.logger;

/**
 * @Author robert
 * @Date 2021/1/28 18:10
 * @Version 1.0
 */
  /**
   * 自定义操作日志注解
    * @author wu
   */

import java.lang.annotation.*;

@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented
public @interface OperLog {
    String model() default ""; // 操作模块
    String type() default "";  // 操作类型
    String desc() default "";  // 操作说明
}
