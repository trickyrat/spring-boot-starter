package com.trickyrat.springbootstarter.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    private final StringRedisTemplate redisTemplate;

    public HelloController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @ResponseBody
    @GetMapping(value = "/")
    public String greeting() {
        return "Hello from SpringBoot 3!";
    }

    @ResponseBody
    @GetMapping(value = "/location")
    public String location(@RequestParam(value = "key", defaultValue = "") String key,
                           @RequestParam(value = "member", defaultValue = "") String member) {
        List<String> geohashs = redisTemplate.opsForGeo().hash(key, member);
        String res = "";
        if (geohashs != null) {
            for (String geohash : geohashs) {
                res = geohash;
            }
        }
        return res;
    }
}
