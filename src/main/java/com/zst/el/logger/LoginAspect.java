package com.zst.el.logger;

import com.alibaba.fastjson.JSON;
import com.zst.el.bean.LoginLogInfo;
import com.zst.el.controller.RedisController;
import com.zst.el.utils.DateUtil;
import com.zst.el.utils.IpUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author robert
 * @date 2021/4/14 18:28
 *
 * 登录日志实现
 */
@Aspect
@Component
public class LoginAspect {

    private Logger logger = Logger.getLogger(RedisController.class);
    /**
     * 操作版本号
     * <p>
     * 项目启动时从命令行传入，例如：java -jar xxx.war --version=201902
     * </p>
     */
    private String operVer ="1.0";

//     @Autowired
//     private OperationLogService operationLogService;
//
//     @Autowired
//     private ExceptionLogService exceptionLogService;

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("execution(* com.zst.el.controller..*.*(..))")
    public void loginLogPointCut() {
        logger.info("用户登录中:"+DateUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm:ss"));
    }

    /**
     65    * 设置操作异常切入点记录异常日志 扫描所有controller包下操作
     66   */
    @Pointcut("execution(* com.zst.el.controller..*.*(..))")
    public void loginLogExceptionLogPointCut() {

    }

    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
     * @param joinPoint 切入点
     * @param keys      返回结果
     */
    @AfterReturning(value = "loginLogPointCut()", returning = "keys")
    public void saveOperLog(JoinPoint joinPoint, Object keys) {
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

        String number = request.getParameter("number");

        LoginLogInfo info = new LoginLogInfo();
        try {
            //info.setId(UUIDUtils.getUUID()); // 主键ID
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            LoginLog opLog = method.getAnnotation(LoginLog.class);
            System.out.println("获取到的操作："+opLog);
            if (opLog != null) {
                char operType = opLog.type();
                String operDesc = opLog.desc();
                info.setType(operType); // 操作类型
                info.setDesc(operDesc); // 操作描述
            }
            // 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            // 获取请求的方法名
            String methodName = method.getName();
            methodName = className + "." + methodName;

            // 请求的参数
            Map<String, String> rtnMap = converMap(request.getParameterMap());
            // 将参数所在的数组转换成json
            String params = JSON.toJSONString(rtnMap);

            info.setReqParams(params); // 请求参数
            info.setResults(JSON.toJSONString(keys)); // 返回结果
            info.setUserId(number); // 请求用户ID
            info.setReqIp(IpUtils.getIpAddr(request)); // 请求IP
            info.setIpAddress(IpUtils.getIpVoByRequest(request).getCity());
            info.setInsetDate(DateUtil.dateToString(new Date())); // 创建时间
            info.setVersion(operVer); // 操作版本

            //operationLogService.insert(operlog);
            System.out.println(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 转换request 请求参数
     *
     * @param paramMap request获取的参数数组
     */
    public Map<String, String> converMap(Map<String, String[]> paramMap) {
        Map<String, String> rtnMap = new HashMap<String, String>();
        for (String key : paramMap.keySet()) {
            rtnMap.put(key, paramMap.get(key)[0]);
        }
        return rtnMap;
    }


    /**
     * 转换异常信息为字符串
     *
     * @param exceptionName    异常名称
     * @param exceptionMessage 异常信息
     * @param elements         堆栈信息
     */
    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuffer strbuff = new StringBuffer();
        for (StackTraceElement stet : elements) {
            strbuff.append(stet + "\n");
        }
        String message = exceptionName + ":" + exceptionMessage + "\n\t" + strbuff.toString();
        return message;
    }
}
