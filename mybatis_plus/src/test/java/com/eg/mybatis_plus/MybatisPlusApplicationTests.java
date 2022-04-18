package com.eg.mybatis_plus;

import com.eg.mybatis_plus.entity.User;
import com.eg.mybatis_plus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    UserMapper userMapper;  //CodeGenerator生成的持久类没有加注解@Repository，需要自己添加，否则找不到注入的对象

    @Test
    void contextLoads() {
    }

    @Test
    void testFindAll(){
        List<User> users = userMapper.selectList(null);
        log.info("{}",users);
    }

    @Test
    void testAdd(){
        User user=new User();
        user.setAge(21);
        user.setName("k");
        user.setEmail("1921302384@qq.com");
        int insert = userMapper.insert(user);
        log.info("{}",insert);
    }
}
