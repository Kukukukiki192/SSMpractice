package com.spring.test;

import com.spring.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试AOP配置
 */
public class AOPTest {

//    @Autowired
//    IAccountService as=null;

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");//得到代理对象
        as.saveAccount();
        as.updateAccount(1);
        as.deleteAccount();
    }
}
