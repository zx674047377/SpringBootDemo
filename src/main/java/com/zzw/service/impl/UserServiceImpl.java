package com.zzw.service.impl;

import com.zzw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addUser(String username, String password) {
        String sql = "insert into user (username,password) values (?,?)";
        jdbcTemplate.update(sql, username, password);
    }
}
