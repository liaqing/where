package com.where.where_web.business.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.where.where_web.business.dao.GoodsCategoryDao;
import com.where.where_web.business.model.GoodsCategory;
import com.where.where_web.business.service.GoodsCategoryService;

@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
	@Inject
	private GoodsCategoryDao goodsCategoryDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return goodsCategoryDao.deleteByPrimaryKey(id);
	}

	@Override
	public List<GoodsCategory> select() {
		return goodsCategoryDao.select();
	}

	@Override
	public int insert(GoodsCategory goodsCategory) {
		return goodsCategoryDao.insert(goodsCategory);
	}

	@Override
	public int insertSelective(GoodsCategory goodsCategory) {
		return goodsCategoryDao.insertSelective(goodsCategory);
	}

	@Override
	public GoodsCategory selectByPrimaryKey(Integer id) {
		return goodsCategoryDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(GoodsCategory goodsCategory) {
		return goodsCategoryDao.updateByPrimaryKeySelective(goodsCategory);
	}

	@Override
	public int updateByPrimaryKey(GoodsCategory goodsCategory) {
		return goodsCategoryDao.updateByPrimaryKey(goodsCategory);
	}

	@Override
	public List<GoodsCategory> selectByShopId(Integer id) {
		return goodsCategoryDao.selectByShopId(id);
	}
	
	

}
