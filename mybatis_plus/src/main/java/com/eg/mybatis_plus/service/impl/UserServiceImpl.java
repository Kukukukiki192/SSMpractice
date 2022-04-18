package com.eg.mybatis_plus.service.impl;

import com.eg.mybatis_plus.entity.User;
import com.eg.mybatis_plus.mapper.UserMapper;
import com.eg.mybatis_plus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author K
 * @since 2021-07-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
