package com.zzg.system.aspect;


import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zzg.common.util.HttpContextUtils;
import com.zzg.common.util.IPUtils;
import com.zzg.config.FebsProperties;
import com.zzg.system.domain.SysLog;
import com.zzg.system.domain.User;
import com.zzg.system.service.LogService;

/**
 * 
 * @ClassName:  LogAspect   
 * @Description:AOP 记录用户操作日志 
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 下午2:24:27   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private FebsProperties febsProperties;

    @Autowired
    private LogService logService;


    @Pointcut("@annotation(com.zzg.common.annotation.Log)")
    public void pointcut() {
        // do nothing
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        // 执行方法
        result = point.proceed();
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        String ip = IPUtils.getIpAddr(request);
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        if (febsProperties.isOpenAopLog()) {
            // 保存日志
            User user = (User)SecurityUtils.getSubject().getPrincipal();
            SysLog log = new SysLog();
           
            log.setUsername(user.getUsername());
            log.setIp(ip);
            log.setTime(time);
            logService.saveLog(point, log);
        }
        return result;
    }
}
