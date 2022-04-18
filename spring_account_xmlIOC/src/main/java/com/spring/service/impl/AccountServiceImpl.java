package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.domain.Account;
import com.spring.service.IAccountService;

import java.util.List;

/**
 * 账户 业务层 实现类
 */
public class AccountServiceImpl implements IAccountService {
    /**
     * 调用持久层
     */
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccountById(Integer accountId) {
        accountDao.deleteAccountById(accountId);
    }
}
