package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 异常处理
     * @return
     */
    @RequestMapping("/login")
    public String testInterceptor() {
        System.out.println("testInterceptor...");

        return "success";
    }
}
