package com.hehe;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hehe.mapper")
public class MybatisCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisCommonApplication.class, args);
	}
}
