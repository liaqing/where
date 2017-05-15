package com.where.where_web.business.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_web.business.dao.ShopCategoryShopDao;
import com.where.where_web.business.model.ShopCategoryShop;

@Repository("shopCategoryShopDao")
public class ShopCategoryShopDaoImpl implements ShopCategoryShopDao {
	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ShopCategoryShop> selectByShopId(Integer id) {
		return sqlSession.selectList(ShopCategoryShop.class.getName()+".selectByShopId", id);
	}

	@Override
	public List<ShopCategoryShop> selectByShopCategoryId(Integer id) {
		return sqlSession.selectList(ShopCategoryShop.class.getName()+".selectByShopCategoryId", id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(ShopCategoryShop.class.getName()+".deleteByPrimaryKey", id);
	}

	@Override
	public int insert(ShopCategoryShop shopCategoryShop) {
		return sqlSession.insert(ShopCategoryShop.class.getName()+".insert", shopCategoryShop);
	}

	@Override
	public int insertSelective(ShopCategoryShop shopCategoryShop) {
		return sqlSession.insert(ShopCategoryShop.class.getName()+".insertSelective", shopCategoryShop);
	}

	@Override
	public ShopCategoryShop selectByPrimaryKey(Integer id) {
		return sqlSession.selectOne(ShopCategoryShop.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(ShopCategoryShop shopCategoryShop) {
		return sqlSession.update(ShopCategoryShop.class.getName()+".updateByPrimaryKeySelective", shopCategoryShop);
	}

	@Override
	public int updateByPrimaryKey(ShopCategoryShop shopCategoryShop) {
		return sqlSession.update(ShopCategoryShop.class.getName()+".updateByPrimaryKey", shopCategoryShop);
	}

}
