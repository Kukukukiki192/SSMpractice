package com.hehe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * 1.静态定时任务（基于注解）
 * 缺点：调整执行周期，需要重启应用才能生效
 *
 * Cron表达式参数分别表示：
 * 秒（0~59） 例如0/5表示每5秒
 * 分（0~59）
 * 时（0~23）
 * 月的某天（0~31） 需计算
 * 月（0~11）
 * 周几（ 可填1-7 或 SUN/MON/TUE/WED/THU/FRI/SAT）
 */
@Configuration //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling // 2.开启定时任务
public class SimpleScheduleConfig {
    //3.添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks() {
        System.err.println("执行定时任务1: " + LocalDateTime.now());
    }
}