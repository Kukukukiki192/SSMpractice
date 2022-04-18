package com.spring.service.impl;

import com.spring.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        System.out.println("执行保存");
        int i=1/0;
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行更新"+i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行删除");
        return 0;
    }
}
