package com.where.where_web.business.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_user_management.model.Pager;
import com.where.where_user_management.model.SystemContext;
import com.where.where_web.business.dao.ShopDao;
import com.where.where_web.business.model.Shop;
@Repository("shopDao")
public class ShopDaoImpl implements ShopDao {
	
	@Inject
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public Shop selectByBusinessId(Integer id) {
		return sqlSession.selectOne(Shop.class.getName()+".selectByBusinessId", id);
	}

	@Override
	public List<Shop> select() {
		return sqlSession.selectList(Shop.class.getName()+".select");
	}

	@Override
	public Shop selectByName(Shop shop) {
		return sqlSession.selectOne(Shop.class.getName()+".selectByName", shop);
	}

	@Override
	public List<Shop> selectLike(Shop shop) {
		
		return sqlSession.selectList(Shop.class.getName()+".selectLike", shop);
	}

	@Override
	public Integer findCount(Shop shop) {
		Map<String, Object> map=new HashMap<>();
		map.put("shop", shop);
		return sqlSession.selectOne(Shop.class.getName()+".findCount", map);
	}

	@Override
	public Pager<Shop> find(Shop shop) {
		Integer pageNo=SystemContext.getPageNo();
		Integer pageSize=SystemContext.getPageSize();
		Map<String, Object> map=new HashMap<>();
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		map.put("shop", shop);
		List<Shop> list=sqlSession.selectList(Shop.class.getName()+".find", map);
		Pager<Shop> pager =new Pager<>();
		pager.setList(list);
		pager.setPageNo(pageNo);
		pager.setPageSize(pageSize);
		Integer totalNum=findCount(shop);
		pager.setTotalNum(totalNum);
		return pager;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(Shop.class.getName()+".deleteByPrimaryKey", id);
	}

	@Override
	public int insert(Shop shop) {
		return sqlSession.insert(Shop.class.getName()+".insert", shop);
	}

	@Override
	public int insertSelective(Shop shop) {
		return sqlSession.insert(Shop.class.getName()+".insertSelective", shop);
	}

	@Override
	public Shop selectByPrimaryKey(Integer id) {
		return sqlSession.selectOne(Shop.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(Shop shop) {
		return sqlSession.update(Shop.class.getName()+".updateByPrimaryKeySelective", shop);
	}

	@Override
	public int updateByPrimaryKey(Shop shop) {
		return sqlSession.update(Shop.class.getName()+".updateByPrimaryKey", shop);
	}

}
