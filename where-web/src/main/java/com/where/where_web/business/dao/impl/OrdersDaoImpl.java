package com.where.where_web.business.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_web.business.dao.OrdersDao;
import com.where.where_web.business.model.Orders;
@Repository("ordersDao")
public class OrdersDaoImpl implements OrdersDao {
	@Inject
	private SqlSessionTemplate sqlSession;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(Orders.class.getName()+".deleteByPrimaryKey", id);
	}

	@Override
	public int insert(Orders orders) {
		return sqlSession.insert(Orders.class.getName()+".insert", orders);
	}

	@Override
	public int insertSelective(Orders orders) {
		return sqlSession.insert(Orders.class.getName()+".insertSelective", orders);
	}

	@Override
	public Orders selectByPrimaryKey(Integer id) {
		return sqlSession.selectOne(Orders.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(Orders orders) {
		return sqlSession.update(Orders.class.getName()+".updateByPrimaryKeySelective", orders);
	}

	@Override
	public int updateByPrimaryKey(Orders orders) {
		return sqlSession.update(Orders.class.getName()+".updateByPrimaryKey", orders);
	}

	@Override
	public List<Orders> selectByBusinessId(Integer id) {
		return sqlSession.selectList(Orders.class.getName()+".selectByBusinessId", id);
	}

	@Override
	public List<Orders> selectByUsersId(Integer id) {
		return sqlSession.selectList(Orders.class.getName()+".selectByUsersId", id);
	}

}
