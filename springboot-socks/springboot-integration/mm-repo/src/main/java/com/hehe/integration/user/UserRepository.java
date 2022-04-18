package com.hehe.integration.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 数据层
 */
//接口方法的名称，符合约定则无需实现即可访问
public interface UserRepository extends JpaRepository<User,String> {
}