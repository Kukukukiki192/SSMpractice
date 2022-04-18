package com.hehe.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/** 推荐ErrorController 替代 @ExceptionHandler
 *
 * 主要用途：统一处理错误/异常(针对控制层)
 * 使用说明:
 * {@ControllerAdvice 默认扫描路径：例如com.hehe.controller}
 * {@ExceptionHandler 指定捕捉异常}
 * {@ModelAndView 返回异常信息页(View)}
 * {@ResponseBody 返回异常信息(JSON)}
 *
 * @ControllerAdvice 增强的 Controller,可实现3方面功能：
 * 1.全局异常处理
 * 2.全局数据绑定
 * 3.全局数据预处理
 *
 * 使用@ExceptionHandler时候需注意如下几点：
 * 1.获取异常：直接在方法参数注入
 * 2.常见缺点：无法捕捉404类异常
 * 3.替代方案：实现ErrorController
 *
 * @author yizhiwazi
 */

//在该类中，可以定义多个方法，不同的方法处理不同的异常;也可以在一个方法中处理所有的异常信息
@ControllerAdvice //实现全局异常处理
public class GlobalErrorHandler {
    /**
     * 错误信息页
     */
    private final static String DEFAULT_ERROR_VIEW = "error";

    /**
     * 错误信息构建器
     */
    @Autowired
    private ErrorInfoBuilder errorInfoBuilder;

    /**
     * 根据业务规则,统一处理异常。
     */
    @ExceptionHandler(Exception.class) //指明异常的处理类型(即如果这里指定为 NullpointerException,则数组越界异常就不会进到这个方法中来) 这里在一个方法中处理所有的异常信息
    @ResponseBody
    public Object exceptionHandler(HttpServletRequest request, Throwable error) {
        //1.若为AJAX请求,则返回异常信息(JSON)
        if (isAjaxRequest(request)) {
            return errorInfoBuilder.getErrorInfo(request,error);
        }
        //2.其余请求(预期返回类型为text/html),则返回指定的异常信息页(View).
        return new ModelAndView(DEFAULT_ERROR_VIEW, "errorInfo", errorInfoBuilder.getErrorInfo(request, error));
    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

}