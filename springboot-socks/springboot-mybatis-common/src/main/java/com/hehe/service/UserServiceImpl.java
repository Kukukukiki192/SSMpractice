package com.hehe.service;

import com.hehe.entity.User;
import com.hehe.tools.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService { //在Service实现类继承通用Service

}
