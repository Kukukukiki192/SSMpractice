package com.hehe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OriginWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(OriginWebApplication.class, args);
    }
}
//同时启动两个应用，然后在浏览器访问：http://localhost:8080/index.html ，可以正常接收JSON数据，说明跨域访问成功