package com.epam.jmp.cms.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by alexei.okhrimenko on 20.02.2017.
 */

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class PerformanceAspect {

    @Pointcut("execution(* com.epam.jmp.cms.user.controller.*.*(..))")
    public void controllers() {

    }

    @Around("controllers()")
    public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Going to call the method");
        Object output = proceedingJoinPoint.proceed();
        System.out.println("Method execution completed");
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
        return output;
    }

    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
        return new PerformanceMonitorInterceptor(true);
    }
}
