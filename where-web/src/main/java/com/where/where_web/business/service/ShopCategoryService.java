package com.where.where_web.business.service;

import java.util.List;

import com.where.where_web.business.model.ShopCategory;

public interface ShopCategoryService {
	
	public List<ShopCategory> select();
	
    int deleteByPrimaryKey(Integer id);

    int insert(ShopCategory shopCategory);

    int insertSelective(ShopCategory shopCategory);

    ShopCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopCategory shopCategory);

    int updateByPrimaryKey(ShopCategory shopCategory);
}