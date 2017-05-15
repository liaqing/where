package com.where.where_web.business.dao;

import com.where.where_web.business.model.ShopPicture;

public interface ShopPictureDao {
	
	
	int deleteByShopId(Integer id);
	ShopPicture selectByShopId(Integer id);
	
    int deleteByPrimaryKey(Integer id);

    int insert(ShopPicture shopPicture);

    int insertSelective(ShopPicture shopPicture);

    ShopPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopPicture shopPicture);

    int updateByPrimaryKey(ShopPicture shopPicture);
}