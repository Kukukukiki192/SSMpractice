package com.spring.service.impl;

import com.spring.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("执行保存");
        int i=1/0;
    }

    public void updateAccount(int i) {
        System.out.println("执行更新"+i);
    }

    public int deleteAccount() {
        System.out.println("执行删除");
        return 0;
    }
}
