package com.hehe.controller;

import com.hehe.pojo.Account;
import com.hehe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 操作账户金额   拟正常操作金额提交事务,以及发生异常回滚事务
 */
@RestController
public class AccountController {

    @SuppressWarnings("all")
    @Autowired
    AccountService accountService;

    @GetMapping("/")
    public Account getAccount() {
        //查询账户
        return accountService.getAccount();
    }

    @GetMapping("/add")
    public Object addMoney() {
        try {
            accountService.addMoney();
        } catch (Exception e) {
            return "发生异常了：" + accountService.getAccount();
        }
        return getAccount();
    }
}