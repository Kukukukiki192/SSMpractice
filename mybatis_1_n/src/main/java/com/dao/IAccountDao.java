package com.dao;

import com.domain.Account;
import com.domain.AccountUser;
import com.domain.User;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户，同时获取当前账户所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户 带有用户名、地址
     * @return
     */
    List<AccountUser> findAllAccountUser();
}
