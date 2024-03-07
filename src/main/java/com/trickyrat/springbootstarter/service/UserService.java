package com.trickyrat.springbootstarter.service;

import com.github.pagehelper.PageInfo;
import com.trickyrat.springbootstarter.model.User;

public interface UserService {
    int addUser(User user);
    PageInfo<User> findAllUsers(int pageNum, int pageSize);
}
