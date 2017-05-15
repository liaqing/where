package com.where.where_web.business.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.where.where_web.business.dao.ShopCategoryShopDao;
import com.where.where_web.business.model.ShopCategoryShop;
import com.where.where_web.business.service.ShopCategoryShopService;

@Service("shopCategoryShopService")
public class ShopCategoryShopServiceImpl implements ShopCategoryShopService {
	
	@Inject
	private ShopCategoryShopDao shopCategoryShopDao;
	
	@Override
	public List<ShopCategoryShop> selectByShopId(Integer id) {
		return shopCategoryShopDao.selectByShopId(id);
	}

	@Override
	public List<ShopCategoryShop> selectByShopCategoryId(Integer id) {
		return shopCategoryShopDao.selectByShopCategoryId(id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return shopCategoryShopDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ShopCategoryShop shopCategoryShop) {
		return shopCategoryShopDao.insert(shopCategoryShop);
	}

	@Override
	public int insertSelective(ShopCategoryShop shopCategoryShop) {
		return shopCategoryShopDao.insertSelective(shopCategoryShop);
	}

	@Override
	public ShopCategoryShop selectByPrimaryKey(Integer id) {
		return shopCategoryShopDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ShopCategoryShop shopCategoryShop) {
		return shopCategoryShopDao.updateByPrimaryKeySelective(shopCategoryShop);
	}

	@Override
	public int updateByPrimaryKey(ShopCategoryShop shopCategoryShop) {
		return shopCategoryShopDao.updateByPrimaryKey(shopCategoryShop);
	}

}
