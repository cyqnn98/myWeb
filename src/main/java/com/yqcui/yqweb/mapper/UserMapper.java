package com.yqcui.yqweb.mapper;

import com.yqcui.yqweb.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper{

    User selectById(int id);
    List<User> selectAllUserAndOrders();

}
