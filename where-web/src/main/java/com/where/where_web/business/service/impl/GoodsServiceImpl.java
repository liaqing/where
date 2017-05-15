package com.where.where_web.business.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.where.where_user_management.model.Pager;
import com.where.where_web.business.dao.GoodsDao;
import com.where.where_web.business.model.Goods;
import com.where.where_web.business.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	@Inject
	private GoodsDao goodsDao;
	@Override
	public Goods selectByPrimaryKey(Integer id) {
		return goodsDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Goods> select() {
		return goodsDao.select();
	}

	@Override
	public Goods selectByName(Goods goods) {
		return goodsDao.selectByName(goods);
	}

	@Override
	public List<Goods> selectLike(Goods goods) {
		return goodsDao.selectLike(goods);
	}

	@Override
	public Pager<Goods> find(Goods goods) {
		return goodsDao.find(goods);
	}

	@Override
	public Pager<Goods> findLike(Goods goods) {
		return goodsDao.findLike(goods);
	}

	@Override
	public Integer findCount(Goods goods) {
		return goodsDao.findCount(goods);
	}

	@Override
	public Integer findCountLike(Goods goods) {
		return goodsDao.findCountLike(goods);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return goodsDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Goods goods) {
		return goodsDao.insert(goods);
	}

	@Override
	public int insertSelective(Goods goods) {
		return goodsDao.insertSelective(goods);
	}

	@Override
	public int updateByPrimaryKeySelective(Goods goods) {
		return goodsDao.updateByPrimaryKeySelective(goods);
	}

	@Override
	public int updateByPrimaryKey(Goods goods) {
		return goodsDao.updateByPrimaryKey(goods);
	}

	@Override
	public List<Goods> selectByShopId(Integer id) {
		return goodsDao.selectByShopId(id);
	}

	@Override
	public List<Goods> selectByShopCategoryId(Integer id) {
		return goodsDao.selectByShopCategoryId(id);
	}

}
