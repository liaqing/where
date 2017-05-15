package com.where.where_web.business.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_web.business.dao.GoodsCategoryDao;
import com.where.where_web.business.model.GoodsCategory;

@Repository("goodsCategoryDao")
public class GoodsCategoryDaoImpl implements GoodsCategoryDao {
	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(GoodsCategory.class.getName()+".deleteByPrimaryKey", id);
	}

	@Override
	public List<GoodsCategory> select() {
		return sqlSession.selectList(GoodsCategory.class.getName()+".select");
	}

	@Override
	public int insert(GoodsCategory goodsCategory) {
		return sqlSession.insert(GoodsCategory.class.getName()+".insert", goodsCategory);
	}

	@Override
	public int insertSelective(GoodsCategory goodsCategory) {
		return sqlSession.insert(GoodsCategory.class.getName()+".insertSelective", goodsCategory);
	}

	@Override
	public GoodsCategory selectByPrimaryKey(Integer id) {
		return sqlSession.selectOne(GoodsCategory.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(GoodsCategory goodsCategory) {
		return sqlSession.update(GoodsCategory.class.getName()+".updateByPrimaryKeySelective", goodsCategory);
	}

	@Override
	public int updateByPrimaryKey(GoodsCategory goodsCategory) {
		return sqlSession.update(GoodsCategory.class.getName()+".updateByPrimaryKey", goodsCategory);
	}

	@Override
	public List<GoodsCategory> selectByShopId(Integer id) {
		return sqlSession.selectList(GoodsCategory.class.getName()+".selectByShopId", id);
	}

}
