package com.eg.mybatis_plus.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement    //开启注解事务管理
@MapperScan("com.eg.mybatis_plus.mapper")   //指定要变成实现类的接口所在的包
public class MybatisPlusConfig {

    //添加分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**添加乐观锁插件
     * 适用场景:
         * 更新一条记录时,希望这条记录没有被别人更新->实现线程安全的数据更新
     * 实现方式：(@Version)
         * 取出记录时，获取当前version
         * 更新时，带上这个version
         * 执行更新时， set version = newVersion where version = oldVersion
         * 如果version不对，就更新失败
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
}
