package com.where.where_web.business.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_web.business.dao.ShopCategoryDao;
import com.where.where_web.business.model.ShopCategory;

@Repository("shopCategoryDao")
public class ShopCategoryDaoImpl implements ShopCategoryDao {
	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ShopCategory> select() {
		return sqlSession.selectList(ShopCategory.class.getName()+".select");
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(ShopCategory.class.getName()+".deleteByPrimaryKey", id);
	}

	@Override
	public int insert(ShopCategory shopCategory) {
		return sqlSession.insert(ShopCategory.class.getName()+".insert", shopCategory);
	}

	@Override
	public int insertSelective(ShopCategory shopCategory) {
		return sqlSession.insert(ShopCategory.class.getName()+".insertSelective", shopCategory);
	}

	@Override
	public ShopCategory selectByPrimaryKey(Integer id) {
		return sqlSession.selectOne(ShopCategory.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(ShopCategory shopCategory) {
		return sqlSession.update(ShopCategory.class.getName()+".updateByPrimaryKeySelective", shopCategory);
	}

	@Override
	public int updateByPrimaryKey(ShopCategory shopCategory) {
		return sqlSession.update(ShopCategory.class.getName()+".updateByPrimaryKey", shopCategory);
	}

}
