package com.where.where_web.business.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_web.business.dao.ShopAddressDao;
import com.where.where_web.business.model.ShopAddress;

@Repository("shopAddressDao")
public class ShopAddressDaoImpl implements ShopAddressDao {
	
	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ShopAddress selectByShopId(Integer id) {
		return sqlSession.selectOne(ShopAddress.class.getName()+".selectByShopId", id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(ShopAddress.class.getName()+".deleteByPrimaryKey", id);
	}

	@Override
	public int insert(ShopAddress shopAddress) {
		return sqlSession.insert(ShopAddress.class.getName()+".insert", shopAddress);
	}

	@Override
	public int insertSelective(ShopAddress shopAddress) {
		return sqlSession.insert(ShopAddress.class.getName()+".insertSelective", shopAddress);
	}

	@Override
	public ShopAddress selectByPrimaryKey(Integer id) {
		return sqlSession.selectOne(ShopAddress.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(ShopAddress shopAddress) {
		return sqlSession.update(ShopAddress.class.getName()+".updateByPrimaryKeySelective", shopAddress);
	}

	@Override
	public int updateByPrimaryKey(ShopAddress shopAddress) {
		return sqlSession.update(ShopAddress.class.getName()+".updateByPrimaryKey", shopAddress);
	}

	@Override
	public List<ShopAddress> selectByProCity(ShopAddress shopAddress) {
		
		return sqlSession.selectList(ShopAddress.class.getName()+".selectByProCity", shopAddress);
	}

}
