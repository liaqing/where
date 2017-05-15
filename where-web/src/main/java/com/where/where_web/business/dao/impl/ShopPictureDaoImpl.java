package com.where.where_web.business.dao.impl;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_web.business.dao.ShopPictureDao;
import com.where.where_web.business.model.ShopPicture;

@Repository("shopPictureDao")
public class ShopPictureDaoImpl implements ShopPictureDao {
	
	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ShopPicture selectByShopId(Integer id) {
		return sqlSession.selectOne(ShopPicture.class.getName()+".selectByShopId", id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(ShopPicture.class.getName()+".deleteByPrimaryKey", id);
	}

	@Override
	public int insert(ShopPicture shopPicture) {
		return sqlSession.insert(ShopPicture.class.getName()+".insert", shopPicture);
	}

	@Override
	public int insertSelective(ShopPicture shopPicture) {
		return sqlSession.insert(ShopPicture.class.getName()+".insertSelective", shopPicture);
	}

	@Override
	public ShopPicture selectByPrimaryKey(Integer id) {
		return sqlSession.selectOne(ShopPicture.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(ShopPicture shopPicture) {
		return sqlSession.update(ShopPicture.class.getName()+".updateByPrimaryKeySelective", shopPicture);
	}

	@Override
	public int updateByPrimaryKey(ShopPicture shopPicture) {
		return sqlSession.update(ShopPicture.class.getName()+".updateByPrimaryKey", shopPicture);
	}

	@Override
	public int deleteByShopId(Integer id) {
		
		return sqlSession.delete(ShopPicture.class.getName()+".deleteByShopId", id);
	}

}
