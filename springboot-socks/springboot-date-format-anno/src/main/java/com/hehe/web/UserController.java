package com.hehe.web;

import com.hehe.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class UserController {

    /**
     * 查询用户信息
     */
    @GetMapping("/")
    public User get() {
        log.info("time: {}",new Date());
        return new User("1", "socks", "123456", new Date(), "GMT");
    }

}
