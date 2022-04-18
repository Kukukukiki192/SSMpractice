package com.didispace.chapter51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching //自动化配置合适的缓存管理器（CacheManager）
@SpringBootApplication
public class Chapter51Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter51Application.class, args);
	}

}
