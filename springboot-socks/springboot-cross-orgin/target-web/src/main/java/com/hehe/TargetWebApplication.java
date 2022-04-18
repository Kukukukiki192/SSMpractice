package com.hehe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TargetWebApplication {

    @Bean
    public TomcatServletWebServerFactory tomcat() {
        TomcatServletWebServerFactory tomcatFactory = new TomcatServletWebServerFactory();
        tomcatFactory.setPort(8090); //默认启动8090端口
        return tomcatFactory;
    }

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(TargetWebApplication.class, args);
    }
}
//分别启动两个应用，然后在浏览器访问：http://localhost:8080/index.html ，可以正常接收JSON数据，说明跨域访问成功