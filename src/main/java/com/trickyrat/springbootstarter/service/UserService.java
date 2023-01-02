package com.trickyrat.springbootstarter.service;

import com.trickyrat.springbootstarter.model.User;

import java.util.List;

public interface UserService {
    int addUser(User user);
    List<User> findAllUsers(int pageNum, int pageSize);
}
