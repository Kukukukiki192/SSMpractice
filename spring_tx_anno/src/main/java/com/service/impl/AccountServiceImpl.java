package com.service.impl;

import com.dao.IAccountDao;
import com.domain.Account;
import com.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账户 业务层 实现类
 */
@Service("accountService")
@Transactional
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

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

        int i=1/0;//异常

        accountDao.updateAccount(targrt);

    }
}
