package com.service.impl;

import com.dao.IAccountDao;
import com.domain.Account;
import com.service.IAccountService;

/**
 * 账户 业务层 实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer...");
        Account source=accountDao.findAccountByName(sourceName);
        Account targrt=accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        targrt.setMoney(targrt.getMoney()+money);

        accountDao.updateAccount(source);

//        int i=1/0;//异常

        accountDao.updateAccount(targrt);

    }
}
