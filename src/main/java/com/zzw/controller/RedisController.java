package com.zzw.controller;

import com.alibaba.fastjson.JSONObject;
import com.zzw.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/adduser")
    public String addUser(@RequestBody JSONObject jsonObject) {
        String key = jsonObject.getString("username");
        String value = jsonObject.getString("password");
        try {
            redisService.addUser(key, value);
            return "add success";
        } catch (Exception e) {
            return "add failed";
        }
    }
}
