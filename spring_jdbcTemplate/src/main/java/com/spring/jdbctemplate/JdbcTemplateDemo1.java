package com.spring.jdbctemplate;

import com.spring.dao.IAccountDao;
import com.spring.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate基本用法
 */
public class JdbcTemplateDemo1 {
    // 1.获取容器
    ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
    // 2.获取对象
    IAccountDao accountDao=(IAccountDao) ac.getBean("accountDao");
    // 3.执行操作
    Account account=accountDao.findAccountById(1);
    System.out.println(account);
    account.setMoney(1000f);
}
