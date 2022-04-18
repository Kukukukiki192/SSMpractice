package com.spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 记录日志的工具类 提供公共代码
 */
@Component("logger")
@Aspect//表示是切面类
public class Logger {

    @Pointcut("execution(* com.spring.service.impl.*.*(..))")
    public void pt1(){}

    //前置通知
//    @Before("pt1()")//("pt1()")所有通知都要写 切入点表达式pt1不能少'()'
    public void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志---------");
    }

    //后置 spring中的后置/异常和最终执行在顺序调用上有问题
//    @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志---------");
    }

    //异常
//    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志---------");
    }

    //最终
//    @After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志---------");
    }

    //环绕
    @Around("pt1()")//spring中的后置/异常和最终执行在顺序调用上有问题
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try{
            Object[] args= pjp.getArgs();

            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志---------前置");

            rtValue=pjp.proceed(args);//明确调用业务层方法(切入点方法)

            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志---------后置");

            return rtValue;
        }catch (Throwable t){
            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志---------异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println("环绕通知Logger类中的aroundPrintLog方法开始记录日志---------最终");
        }
    }
}
