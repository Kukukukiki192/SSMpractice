package com.dao;

import com.domain.QueryVo;
import com.domain.User;

import java.util.List;

/**
 * 用户 持久层 接口
 */
public interface IUserDao {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据名称模糊查询用户
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 根据QueryVo中的条件查询用户
     *  把实体类信息封装到vo类,适合多表操作 若查询条件要从多个对象中取出,就需要先把它们包装成1个
     * @param vo
     * @return
     */
    List<User> findByVo(QueryVo vo);

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 获取用户总记录条数
     * @return
     */
    int findTotal();


}
