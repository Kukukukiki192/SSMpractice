package com.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常业务逻辑 抛出的异常在这里接收,然后跳转至提示页面
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取异常对象
        SysException ex=null;
        if(e instanceof SysException){ //测试对象e是否为类的实例
            ex=(SysException) e;//参数Exception是自定义异常类SysException的父类,类型需要强转 父类只有强转为子类才能引用子类方法
        }else{
            ex=new SysException("系统正在维护..");//可以new子类对象
        }

        //创建ModelAndView对象
        ModelAndView mv=new ModelAndView();
        mv.addObject("errorMsg",ex.getMessage());//取出存储的提示信息存到errorMsg中跳转页面后使用
        mv.setViewName("error");//跳转至错误提示页面

        return mv;
    }
}