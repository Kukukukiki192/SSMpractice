package com.service;

import com.domain.Account;

/**
 * 账户 业务层 接口
 */
public interface IAccountService {
    /**
     * 根据Id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账
     * @param sourceName 汇款账户名称
     * @param targetName 收款账户名称
     * @param money      转账金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
