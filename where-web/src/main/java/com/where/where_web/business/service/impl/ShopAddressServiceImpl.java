package com.where.where_web.business.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.where.where_web.business.dao.ShopAddressDao;
import com.where.where_web.business.model.ShopAddress;
import com.where.where_web.business.service.ShopAddressService;

@Service("shopAdressService")
public class ShopAddressServiceImpl implements ShopAddressService {
	@Inject
	private ShopAddressDao ShopAddressDao;
	
	@Override
	public ShopAddress selectByShopId(Integer id) {
		return ShopAddressDao.selectByShopId(id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return ShopAddressDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ShopAddress shopAddress) {
		return ShopAddressDao.insert(shopAddress);
	}

	@Override
	public int insertSelective(ShopAddress shopAddress) {
		return ShopAddressDao.insertSelective(shopAddress);
	}

	@Override
	public ShopAddress selectByPrimaryKey(Integer id) {
		return ShopAddressDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ShopAddress shopAddress) {
		return ShopAddressDao.updateByPrimaryKeySelective(shopAddress);
	}

	@Override
	public int updateByPrimaryKey(ShopAddress shopAddress) {
		return ShopAddressDao.updateByPrimaryKey(shopAddress);
	}

	@Override
	public List<ShopAddress> selectByProCity(ShopAddress shopAddress) {
		
		return ShopAddressDao.selectByProCity(shopAddress);
	}

}
