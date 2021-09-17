package com.zzw.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public String addUser(@RequestBody JSONObject json) {
        String username = json.getString("username");
        String password = json.getString("password");
        try {
            if (!username.isEmpty() && !password.isEmpty()) {
                userService.addUser(username, password);
                return "insert success";
            }
            return "insert failed";
        } catch (Exception e) {
            return "error";
        }


    }
}
