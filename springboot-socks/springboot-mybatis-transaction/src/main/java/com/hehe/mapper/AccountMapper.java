package com.hehe.mapper;

import com.hehe.pojo.Account;
import org.apache.ibatis.annotations.*;


/**
 * 添加了@Mapper注解之后这个接口在编译时会生成相应的实现类
 *
 * 需要注意的是：这个接口中不可以定义同名的方法，因为会生成相同的id
 * 也就是说这个接口是不支持重载的
 */
@Mapper
public interface AccountMapper {

    @Select("select * from account where account_id=1")
    Account getAccount();

    @Update("update account set balance = balance+100 where account_id=1")
    void addMoney();

    //eg:
//    @Select("select * from user where name = #{name} and pwd = #{pwd}")
//    /**
//     * 对于多个参数来说，每个参数之前都要加上@Param注解,要不然会找不到对应的参数进而报错
//
//    !!!无论什么方式,如果涉及多个参数,则必须加上@Param注解,否则无法使用EL表达式获取参数
//     */
//    public User login(@Param("name")String name, @Param("pwd")String pwd);

}