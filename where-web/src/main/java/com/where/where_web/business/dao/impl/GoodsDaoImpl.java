package com.where.where_web.business.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_user_management.model.Pager;
import com.where.where_user_management.model.SystemContext;
import com.where.where_web.business.dao.GoodsDao;
import com.where.where_web.business.model.Goods;

@Repository("goodsDao")
public class GoodsDaoImpl implements GoodsDao {
	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(Goods.class.getName()+".deleteByPrimaryKey", id);
	}

	@Override
	public List<Goods> select() {
		return sqlSession.selectList(Goods.class.getName()+".select");
	}

	@Override
	public Goods selectByName(Goods goods) {
		return sqlSession.selectOne(Goods.class.getName()+".selectByName", goods);
	}

	@Override
	public List<Goods> selectLike(Goods goods) {
		return sqlSession.selectList(Goods.class.getName()+".selectLike", goods);
	}

	@Override
	public Pager<Goods> find(Goods goods) {
		Integer pageNo=SystemContext.getPageNo();
		Integer pageSize=SystemContext.getPageSize();
		
		Map<String, Object> map=new HashMap<>();
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		map.put("goods", goods);
		List<Goods> list=sqlSession.selectList(Goods.class.getName()+".find", map);
		Pager<Goods> pager=new Pager<>();
		pager.setList(list);
		pager.setPageNo(pageNo);
		pager.setPageSize(pageSize);
		Integer totalNum=findCount(goods);
		pager.setTotalNum(totalNum);
		return pager;
	}

	@Override
	public Pager<Goods> findLike(Goods goods) {
		
		Integer pageNo=SystemContext.getPageNo();
		Integer pageSize=SystemContext.getPageSize();
		
		Map<String, Object> map=new HashMap<>();
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		map.put("goods", goods);
		List<Goods> list=sqlSession.selectList(Goods.class.getName()+".findLike", map);
		Pager<Goods> pager=new Pager<>();
		pager.setList(list);
		pager.setPageNo(pageNo);
		pager.setPageSize(pageSize);
		Integer totalNum=findCountLike(goods);
		pager.setTotalNum(totalNum);
		return pager;
	}

	@Override
	public Integer findCount(Goods goods) {
		Map<String, Object> map=new HashMap<>();
		map.put("goods", goods);
		return sqlSession.selectOne(Goods.class.getName()+".findCount", map);
	}

	@Override
	public Integer findCountLike(Goods goods) {
		Map<String, Object> map=new HashMap<>();
		map.put("goods", goods);
		return sqlSession.selectOne(Goods.class.getName()+".findCountLike", map);
	}

	@Override
	public int insert(Goods goods) {
		return sqlSession.insert(Goods.class.getName()+".insert", goods);
	}

	@Override
	public int insertSelective(Goods goods) {
		return sqlSession.insert(Goods.class.getName()+".insertSelective", goods);
	}

	@Override
	public Goods selectByPrimaryKey(Integer id) {
		return sqlSession.selectOne(Goods.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(Goods goods) {
		return sqlSession.update(Goods.class.getName()+".updateByPrimaryKeySelective", goods);
	}

	@Override
	public int updateByPrimaryKey(Goods goods) {
		return sqlSession.update(Goods.class.getName()+".updateByPrimaryKey", goods);
	}

	@Override
	public List<Goods> selectByShopId(Integer id) {
		return sqlSession.selectList(Goods.class.getName()+".selectByShopId", id);
	}

	@Override
	public List<Goods> selectByShopCategoryId(Integer id) {
		return sqlSession.selectList(Goods.class.getName()+".selectByShopCategoryId", id);
	}

}
