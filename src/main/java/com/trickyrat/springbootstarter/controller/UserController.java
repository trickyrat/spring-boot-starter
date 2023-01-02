package com.trickyrat.springbootstarter.controller;


import com.trickyrat.springbootstarter.model.User;
import com.trickyrat.springbootstarter.service.UserService;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping(value = "/", produces = {"application/json;charset=UTF-8"})
    public List<User> findAllUsers(@RequestParam MultiValueMap<String, Integer> filters) {
        int pageNum = filters.getFirst("pageNum");
        int pageSize = filters.getFirst("pageSize");
        return userService.findAllUsers(pageNum, pageSize);
    }
}
