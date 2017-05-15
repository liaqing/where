package com.where.where_web.business.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.where.where_web.business.dao.ShopPictureDao;
import com.where.where_web.business.model.ShopPicture;
import com.where.where_web.business.service.ShopPictureService;

@Service("shopPictureService")
public class ShopPictureServiceImpl implements ShopPictureService {
	@Inject
	private ShopPictureDao shopPictureDao;
	
	@Override
	public ShopPicture selectByShopId(Integer id) {
		return shopPictureDao.selectByShopId(id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return shopPictureDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ShopPicture shopPicture) {
		return shopPictureDao.insert(shopPicture);
	}

	@Override
	public int insertSelective(ShopPicture shopPicture) {
		return shopPictureDao.insertSelective(shopPicture);
	}

	@Override
	public ShopPicture selectByPrimaryKey(Integer id) {
		return shopPictureDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ShopPicture shopPicture) {
		return shopPictureDao.updateByPrimaryKeySelective(shopPicture);
	}

	@Override
	public int updateByPrimaryKey(ShopPicture shopPicture) {
		return shopPictureDao.updateByPrimaryKey(shopPicture);
	}

	@Override
	public int deleteByShopId(Integer id) {
		
		return shopPictureDao.deleteByShopId(id);
	}

}
