package com.where.where_web.business.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.where.where_web.business.dao.ShopCategoryDao;
import com.where.where_web.business.model.ShopCategory;
import com.where.where_web.business.service.ShopCategoryService;

@Service("shopCategoryService")
public class ShopCategoryServiceImpl implements ShopCategoryService {
	
	@Inject
	private ShopCategoryDao shopCategoryDao;
	@Override
	public List<ShopCategory> select() {
		return shopCategoryDao.select();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return shopCategoryDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ShopCategory shopCategory) {
		return shopCategoryDao.insert(shopCategory);
	}

	@Override
	public int insertSelective(ShopCategory shopCategory) {
		return shopCategoryDao.insertSelective(shopCategory);
	}

	@Override
	public ShopCategory selectByPrimaryKey(Integer id) {
		return shopCategoryDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ShopCategory shopCategory) {
		return shopCategoryDao.updateByPrimaryKeySelective(shopCategory);
	}

	@Override
	public int updateByPrimaryKey(ShopCategory shopCategory) {
		return shopCategoryDao.updateByPrimaryKey(shopCategory);
	}

}
