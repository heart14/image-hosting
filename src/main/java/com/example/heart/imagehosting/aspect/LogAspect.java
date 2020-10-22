package com.example.heart.imagehosting.aspect;

import com.example.heart.imagehosting.utils.IPUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @ClassName: LogAspect
 * @Description: AOP切面进行日志打印
 * @Author: jayhe
 * @Date: 2020/1/22 9:34
 * @Version: v1.0
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.example.heart.imagehosting.controller..*.*(..))")
    public void controllerLog() {

    }

    @Pointcut("execution(public * com.example.heart.imagehosting.service.impl..*.*(..))")
    public void serviceLog() {

    }

    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        logger.info("REQUEST FROM     =>{}", IPUtils.getIpAddr(request));
        logger.info("REQUEST PATH     =>{}", request.getRequestURL());
        logger.info("REQUEST METHOD   =>{}", request.getMethod());
        logger.info("REQUEST RESOURCE =>{}{}{}", joinPoint.getSignature().getDeclaringTypeName(), ".", joinPoint.getSignature().getName());
        logger.info("REQUEST ARGS     =>{}", Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "controllerLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        logger.info("RESPONSE         <={}", ret);
    }

    @Before("serviceLog()")
    public void beforeService(JoinPoint joinPoint) throws Throwable {
        logger.info("SERVICE RESOURCE =>{}{}{}", joinPoint.getSignature().getDeclaringTypeName(), ".", joinPoint.getSignature().getName());
        logger.info("SERVICE ARGS     =>{}", Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "rets", pointcut = "serviceLog()")
    public void afterReturningService(Object rets) throws Throwable {
        logger.info("SERVICE RESPONSE <={}", rets);
    }
}
