package com.yqcui.yqweb.controller;

import com.yqcui.yqweb.entity.User;
import com.yqcui.yqweb.service.UserServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceDAO userServiceDAO;

    @GetMapping("/user")
    public User query(){
        return userServiceDAO.selectById(1);
    }

    @GetMapping("/user/findAll")
    public List<User> findAll(){
        return userServiceDAO.selectAllUserAndOrders();
    }
}
