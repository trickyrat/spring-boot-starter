package com.trickyrat.springbootstarter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @ResponseBody
    @GetMapping(value = "/", produces = {"application/json;charset=UTF-8"})
    public String greeting() {
        return "Hello from springboot!";
    }
}
