package com.yqcui.yqweb.service;

import com.yqcui.yqweb.entity.User;

import java.util.List;

public interface UserService {
     User saveUser(User user);
     List<User> getAllUsers();
}