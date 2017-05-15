package com.where.where_web.business.dao;

import java.util.List;

import com.where.where_web.business.model.ShopCategoryShop;

public interface ShopCategoryShopDao {
	
	List<ShopCategoryShop>  selectByShopId(Integer id);
	
	List<ShopCategoryShop> selectByShopCategoryId(Integer id);
	
    int deleteByPrimaryKey(Integer id);

    int insert(ShopCategoryShop shopCategoryShop);

    int insertSelective(ShopCategoryShop shopCategoryShop);

    ShopCategoryShop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopCategoryShop shopCategoryShop);

    int updateByPrimaryKey(ShopCategoryShop shopCategoryShop);
}