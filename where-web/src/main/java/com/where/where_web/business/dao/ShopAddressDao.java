package com.where.where_web.business.dao;

import java.util.List;

import com.where.where_web.business.model.ShopAddress;

public interface ShopAddressDao {
	List<ShopAddress> selectByProCity(ShopAddress shopAddress);
	
	ShopAddress selectByShopId(Integer id);
	
    int deleteByPrimaryKey(Integer id);

    int insert(ShopAddress shopAddress);

    int insertSelective(ShopAddress shopAddress);

    ShopAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopAddress shopAddress);

    int updateByPrimaryKey(ShopAddress shopAddress);
}