package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 注解
 */
@Controller
@RequestMapping("/anno")
public class AnnoController {


    /**
     * RequestParam注解
     * @param
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name="name") String username){
        System.out.println("testAnno...");
        System.out.println(username);
        return "success";
    }

    /**
     * RequestBody注解 获取请求体内容
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("testAnno...");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("testAnno...");
        System.out.println(id);
        return "success";
    }

    /**
     * RequestHeader注解
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("testAnno...");
        System.out.println(header);
        return "success";
    }

    /**
     * CookieValue注解
     * @param cookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("testAnno...");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(){
        System.out.println("testAnno...");
        return "success";
    }
    @ModelAttribute
    public String print(){
        System.out.println("print...");
        return "success";
    }
}
