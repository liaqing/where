package com.where.where_web.business.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.where.where_web.business.dao.OrdersDao;
import com.where.where_web.business.model.Orders;
import com.where.where_web.business.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
	@Inject
	private OrdersDao ordersDao;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return ordersDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Orders orders) {
		return ordersDao.insert(orders);
	}

	@Override
	public int insertSelective(Orders orders) {
		return ordersDao.insertSelective(orders);
	}

	@Override
	public Orders selectByPrimaryKey(Integer id) {
		return ordersDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Orders orders) {
		return ordersDao.updateByPrimaryKeySelective(orders);
	}

	@Override
	public int updateByPrimaryKey(Orders orders) {
		return ordersDao.updateByPrimaryKey(orders);
	}

	@Override
	public List<Orders> selectByBusinessId(Integer id) {
		return ordersDao.selectByBusinessId(id);
	}

	@Override
	public List<Orders> selectByUsersId(Integer id) {
		return ordersDao.selectByUsersId(id);
	}

}
