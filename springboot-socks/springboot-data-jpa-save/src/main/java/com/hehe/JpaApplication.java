package com.hehe;

import com.hehe.common.SimpleJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//在启动类标记修改过的通用JpaRepository的实现类
@EnableJpaRepositories(value = "com.hehe.repository", repositoryBaseClass = SimpleJpaRepositoryImpl.class)
@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
}
