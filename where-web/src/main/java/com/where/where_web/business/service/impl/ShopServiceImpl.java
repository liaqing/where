package com.where.where_web.business.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.where.where_user_management.model.Pager;
import com.where.where_web.business.dao.ShopDao;
import com.where.where_web.business.model.Shop;
import com.where.where_web.business.service.ShopService;

@Service("shopService")
public class ShopServiceImpl implements ShopService {
	@Inject
	private ShopDao shopDao;
	
	@Override
	public Shop selectByBusinessId(Integer id) {
		return shopDao.selectByBusinessId(id);
	}

	@Override
	public List<Shop> select() {
		return shopDao.select();
	}

	@Override
	public Shop selectByName(Shop shop) {
		return shopDao.selectByName(shop);
	}

	@Override
	public List<Shop> selectLike(Shop shop) {
		return shopDao.selectLike(shop);
	}

	@Override
	public Integer findCount(Shop shop) {
		return shopDao.findCount(shop);
	}

	@Override
	public Pager<Shop> find(Shop shop) {
		return shopDao.find(shop);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return shopDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Shop shop) {
		return shopDao.insert(shop);
	}

	@Override
	public int insertSelective(Shop shop) {
		return shopDao.insertSelective(shop);
	}

	@Override
	public Shop selectByPrimaryKey(Integer id) {
		return shopDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Shop shop) {
		return shopDao.updateByPrimaryKeySelective(shop);
	}

	@Override
	public int updateByPrimaryKey(Shop shop) {
		// TODO Auto-generated method stub
		return 0;
	}

}
