package com.spring.dao;

import com.spring.domain.Account;

import java.util.List;

/**
 * 账户 持久层 接口
 */
public interface IAccountDao {
    /**
     * 查询 all
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询 one
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除 one
     * @param accountId
     */
    void deleteAccountById(Integer accountId);
}
