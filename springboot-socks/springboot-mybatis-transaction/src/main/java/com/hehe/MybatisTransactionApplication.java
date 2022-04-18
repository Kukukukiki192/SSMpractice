package com.hehe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

//配置数据源和开启Mybatis的自动驼峰映射
@SpringBootApplication
public class MybatisTransactionApplication {

    public static void main(String[] args) {
        //1.初始化
        SpringApplication application=  new SpringApplication(MybatisTransactionApplication.class);

        //2.添加数据源
        Map<String,Object> map = new HashMap<>();
        map.put("spring.datasource.url","jdbc:mysql://localhost:3306/socks?useSSL=false");
        map.put("spring.datasource.username","root");
        map.put("spring.datasource.password","1111");

        //3.开启驼峰映射 (Such as account_id ==> accountId)
        map.put("mybatis.configuration.map-underscore-to-camel-case",true);
        application.setDefaultProperties(map);

        //4.启动应用
        application.run(args);
    }
}
