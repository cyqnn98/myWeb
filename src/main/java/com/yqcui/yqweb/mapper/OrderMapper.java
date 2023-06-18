package com.yqcui.yqweb.mapper;

import com.yqcui.yqweb.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper{

    @Select("select * from `Order` where uid=#{uid}")
    List<Order> selectByUid(int uid);

    @Select("select * from Order")
    public List<Order> find();
}
