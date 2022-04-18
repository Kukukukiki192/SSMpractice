package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器类 接受请求
 */
@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping(path="/hello")
    public String sayHello(){
        System.out.println("hello");
        return "success";
    }

//    @RequestMapping("/testRequestMapping")
//    public String testRequestMapping(){
//        System.out.println("testRequestMapping...");
//        return "success";
//    }
//
//    @RequestMapping(path="/testRequestMapping",method = {RequestMethod.POST})
//    public String testRequestMapping(){
//        System.out.println("testRequestMapping...");
//        return "success";
//    }

    @RequestMapping(value="/testRequestMapping",params = {"username=10"},headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("testRequestMapping...");
        return "success";
    }








}
