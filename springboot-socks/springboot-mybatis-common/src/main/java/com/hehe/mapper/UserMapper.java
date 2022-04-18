package com.hehe.mapper;

import com.hehe.entity.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * 继承通用Mapper获取CURD方法
 */
public interface UserMapper extends Mapper<User> { //在Mapper接口继承通用Mapper并指定泛型

}
