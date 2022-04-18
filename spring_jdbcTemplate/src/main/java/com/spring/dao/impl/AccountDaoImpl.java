package com.spring.dao.impl;

import com.spring.dao.IAccountDao;
import com.spring.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 账户 持久层 实现类
 */
public class AccountDaoImpl implements IAccountDao {



    public Account findAccountById(Integer accountId) {
        List<Account> accounts=jdbcTemplate.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> accounts=jdbcTemplate.query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty())
            return null;
        if(accounts.size()>1)
            throw new RuntimeException("结果集不唯一");
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
       jdbcTemplate.query("update account set name=?,money=? where id=?",new BeanPropertyRowMapper<Account>(Account.class),account.getName(),account.getMoney(),account.getId());
    }
}
