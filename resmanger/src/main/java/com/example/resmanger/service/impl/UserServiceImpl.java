package com.example.resmanger.service.impl;

import com.example.resmanger.entity.User;
import com.example.resmanger.mapper.UserMapper;
import com.example.resmanger.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ydc
 * @since 2022-11-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User test(){
        User user = userMapper.selectById(1);
        return user;
    }
}
