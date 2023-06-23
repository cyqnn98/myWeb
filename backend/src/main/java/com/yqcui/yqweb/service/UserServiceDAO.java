package com.yqcui.yqweb.service;

import com.yqcui.yqweb.entity.User;

import java.util.List;
public interface UserServiceDAO {
    User selectById(int id);
    List<User> selectAllUserAndOrders();
}
