package com.hehe.service;

import com.hehe.mapper.AccountMapper;
import com.hehe.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class AccountService {

    @SuppressWarnings("all")
    @Autowired
    AccountMapper accountMapper;

    public Account getAccount() {
        return accountMapper.getAccount();
    }


    //常见坑点1：遇到检测异常时，事务默认不回滚
    @Transactional
    public void addMoney1() throws Exception {
        //先增加余额
        accountMapper.addMoney();
        //然后遇到故障
        throw new SQLException("发生异常了.."); //检测到异常 事务不回滚 Controller捕获到异常并处理
    }
    /**
     * Spring的默认的事务规则是遇到运行异常（RuntimeException及其子类）和程序错误（Error）才会进行事务回滚，显然SQLException并不属于这个范围。
     * 如果想针对检测异常进行事务回滚，可以在@Transactional 注解里使用rollbackFor 属性明确指定异常
     */
    //解决：
    @Transactional(rollbackFor = Exception.class)
    public void addMoney2() throws Exception {
        //先增加余额
        accountMapper.addMoney();
        //然后遇到故障
        throw new SQLException("发生异常了.."); //检测到异常 事务回滚 Controller捕获到异常并处理
    }


    //常见坑点2： 在业务层捕捉异常后，发现事务不生效
    @Transactional
    public void addMoney3() throws Exception {
        //先增加余额
        accountMapper.addMoney();
        //谨慎：尽量不要在业务层捕捉异常并处理
        try {
            throw new SQLException("发生异常了..");
        } catch (Exception e) {
            e.printStackTrace(); //处理并打印异常 事务不生效 Controller未捕获到异常
        }
    }
    /**
     * 在业务层手工捕捉并处理了异常，你都把异常“吃”掉了，Spring自然不知道这里有错，更不会主动去回滚数据
     * 上面这段代码直接导致增加余额的事务回滚没有生效
     * 不要小瞧了这些细节，往前暴露异常很大程度上很能够帮我们快速定位问题，而不是经常在项目上线后出现问题，却无法刨根知道哪里报错
     *
     * 推荐做法：若非实际业务要求，则在业务层统一抛出异常，然后在控制层统一处理
     */
    //解决：
    @Transactional  //开启事务,执行数据库操作后抛出异常
    public void addMoney() throws Exception {
        //先增加余额
        accountMapper.addMoney();
        //然后遇到故障
        throw new RuntimeException("发生异常了.."); //检测到异常 事务回滚 Controller捕获到异常并处理
    }
}