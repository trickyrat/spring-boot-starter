package com.trickyrat.springbootstarter.service.impl;

import com.github.pagehelper.PageHelper;
import com.trickyrat.springbootstarter.mapper.UserMapper;
import com.trickyrat.springbootstarter.model.User;
import com.trickyrat.springbootstarter.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="userService")
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> findAllUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUsers();
    }
}
