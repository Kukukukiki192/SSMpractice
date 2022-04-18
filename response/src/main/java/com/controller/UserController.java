package com.controller;

import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * String
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString..");

        //模拟从数据库中查询User
        User user=new User();
        user.setUsername("K");
        user.setPassword("1111");
        user.setAge(20);
        model.addAttribute("user",user);

        return "success";
    }

    /**
     * void
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid..");
        //转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向 无法找到WEB-INF目录中的jsp
        response.sendRedirect(request.getContextPath()+"/index.jsp");

//        //设置中文乱码
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        //直接响应(输出到浏览器)
//        response.getWriter.write("Hello");//getWriter标红?

        return;
    }

    /**
     * ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView..");
        //创建对象
        ModelAndView mv=new ModelAndView();
        //模拟从数据库中查询User
        User user=new User();
        user.setUsername("K");
        user.setPassword("1111");
        user.setAge(20);
        //user存到mv对象,也会存到request对象中
        mv.addObject("user",user);
        //跳转页面
        mv.setViewName("success");

        return mv;
    }

    /**
     * 使用关键字进行 转发_重定向
     * @param model
     * @return
     */
    @RequestMapping("/testForward_Redirect")
    public String testForward_Redirect(Model model){
        System.out.println("testForward_Redirect..");
        //转发 ~request.getRequestDispatcher("url").forward(request,response);
//        return "forward:/WEB-INF/pages/success.jsp";
        //重定向 ~“response.sendRedirect(url);
        return "redirect:/index.jsp";
//        return "success";
    }

//    @RequestMapping("/testAjax")
//    public void testAjax(@RequestBody String body){
//        System.out.println("testAjax..");
//        System.out.println(body);
//    }

    /**
     * 模拟异步请求响应
     * @param user
     * @return
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax..");
        //前端传ajax请求(json字符串),后端将json字符串装到user对象中
        System.out.println(user);
        //模拟查询DB
        user.setUsername("KK");
        user.setAge(33);
        //响应
        return user;
    }

}
