package com.where.where_web.business.dao;

import java.util.List;

import com.where.where_web.business.model.GoodsCategory;

public interface GoodsCategoryDao {
    public int deleteByPrimaryKey(Integer id);

    public List<GoodsCategory> select();
    
     
    public int insert(GoodsCategory goodsCategory);

    public int insertSelective(GoodsCategory goodsCategory);

    public GoodsCategory selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(GoodsCategory goodsCategory);

    public int updateByPrimaryKey(GoodsCategory goodsCategory);
    
    public List<GoodsCategory> selectByShopId(Integer id);
}