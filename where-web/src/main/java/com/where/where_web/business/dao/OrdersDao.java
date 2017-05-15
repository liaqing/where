package com.where.where_web.business.dao;

import java.util.List;

import com.where.where_web.business.model.Orders;

public interface OrdersDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders orders);

    int insertSelective(Orders orders);

    Orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders orders);

    int updateByPrimaryKey(Orders orders);
    
    List<Orders> selectByBusinessId(Integer id);
    
    List<Orders> selectByUsersId(Integer id);
}