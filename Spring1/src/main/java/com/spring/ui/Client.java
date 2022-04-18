package com.spring.ui;

import com.spring.dao.IAccountDao;
import com.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 *
 * ApplicationContext的三个常用实现类：
 *      *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了(更常用 配置文件应跟项目放在一起)
 *      *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限 不同系统权限不同）
 *      *
 *      *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的
 *
 * 核心容器的两个接口引发出的问题：
 *      *  ApplicationContext:     单例对象适用              采用此接口
 *      *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
 *      *
 *      *  BeanFactory:            多例对象使用
 *      *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
 */
public class Client {

    public static void main(String[] args) {
//        IAccountService as = new AccountServiceImpl();
        //获取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac=new FileSystemXmlApplicationContext("C:\\Users\\K\\OneDrive\\桌面\\bean.xml");
        //由id获取bean对象
        IAccountService as=(IAccountService)ac.getBean("accountService");
        IAccountDao adao=(IAccountDao)ac.getBean("accountDao");
        System.out.println(as);
        System.out.println(adao);
//        as.saveAccount();


    }
}
