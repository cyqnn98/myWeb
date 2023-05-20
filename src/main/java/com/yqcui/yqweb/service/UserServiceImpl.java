package com.yqcui.yqweb.service;

import com.yqcui.yqweb.entity.User;
import com.yqcui.yqweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceDAO {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectAllUserAndOrders() {
        return userMapper.selectAllUserAndOrders();
    }

}

