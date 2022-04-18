package com.dao;

import com.domain.User;

import java.util.List;

/**
 * 用户 持久层 接口
 */
public interface IUserDao {
    /**
     * 查询所有用户，同时获取用户下所有账户的信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);


}
