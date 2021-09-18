package com.zzw.service.impl;

import com.zzw.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void addUser(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
}
