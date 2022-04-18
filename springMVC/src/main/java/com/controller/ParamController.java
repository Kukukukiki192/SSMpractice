package com.controller;

import com.domain.Account;
import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 传值
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 传值 简单类型
     * @param username
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username){
        System.out.println("testParam...");
        System.out.println("用户名 "+username);
        return "success";
    }

    /**
     * 传值 数据封装到JavaBean类中 + 类中存在list、map集合
     * @param account
     * @return
     */
    @RequestMapping("/testSaveAccount")
    public String testSaveAccount(Account account){
        System.out.println("testParam...");
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换 定义类->注册转换器
     * @param user
     * @return
     */
    @RequestMapping("/testSaveUser")
    public String testSaveUser(User user){
        System.out.println("testParam...");
        System.out.println(user);
        return "success";
    }

    /**
     * Servlet原生API
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("testParam...");
        System.out.println(request);
        HttpSession session=request.getSession();
        System.out.println(session);
        ServletContext context=session.getServletContext();
        System.out.println(context);
        System.out.println(response);
        return "success";
    }




}
