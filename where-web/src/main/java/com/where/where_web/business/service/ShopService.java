package com.where.where_web.business.service;

import java.util.List;

import com.where.where_user_management.model.Pager;
import com.where.where_web.business.model.Shop;

public interface ShopService {
	public Shop selectByBusinessId(Integer id);
	
	public List<Shop> select();
	
	public Shop selectByName(Shop shop);
	
	public List<Shop> selectLike(Shop shop);
	
	public Integer findCount(Shop shop);
	
	public Pager<Shop> find(Shop shop);
	
    public int deleteByPrimaryKey(Integer id);

    public int insert(Shop shop);

    public int insertSelective(Shop shop);

    public Shop selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Shop shop);

    public int updateByPrimaryKey(Shop shop);
    
    
}