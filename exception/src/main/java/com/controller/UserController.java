package com.controller;

import com.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 异常处理
     * @return
     */
    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException...");
        try {
            //模拟异常
            int i=1/0;  //-->1.编写自定义异常类(做提示信息) 2.编写异常处理器 3.配置异常处理器(跳转至提示页面)
        } catch (Exception e) {
            //在控制台打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("Error:/0!");
        }
        return "success";
    }
}
