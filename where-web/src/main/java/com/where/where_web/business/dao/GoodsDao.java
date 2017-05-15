package com.where.where_web.business.dao;

import java.util.List;

import com.where.where_user_management.model.Pager;
import com.where.where_web.business.model.Goods;

public interface GoodsDao {
    public int deleteByPrimaryKey(Integer id);
    
    public List<Goods> select();
    
    public Goods selectByName(Goods goods);
    
    public List<Goods> selectLike(Goods goods);
    
    public Pager<Goods> find (Goods goods);
    
    public Pager<Goods> findLike(Goods goods);
    
    public Integer findCount(Goods goods);
    
    public Integer findCountLike(Goods goods);
    
    public int insert(Goods goods);

    public int insertSelective(Goods goods);

    public Goods selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Goods goods);

    public int updateByPrimaryKey(Goods goods);
    
    public List<Goods> selectByShopId(Integer id);
    
    public List<Goods> selectByShopCategoryId(Integer id);
}