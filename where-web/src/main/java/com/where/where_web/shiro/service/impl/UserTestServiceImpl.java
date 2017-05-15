package com.where.where_web.shiro.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.where.where_web.shiro.dao.UserTestDao;
import com.where.where_web.shiro.entity.UserTest;
import com.where.where_web.shiro.service.PasswordHelper;
import com.where.where_web.shiro.service.UserTestService;

@Service("userTestService")
public class UserTestServiceImpl implements UserTestService {
	@Resource
	private UserTestDao userTestDao;
	private PasswordHelper passwordHelper =new PasswordHelper();
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return userTestDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserTest record) {
		passwordHelper.encryptPassword(record);
		return userTestDao.insert(record);
	}

	@Override
	public int insertSelective(UserTest record) {
		passwordHelper.encryptPassword(record);
		return userTestDao.insertSelective(record);
	}

	@Override
	public UserTest selectByPrimaryKey(Integer id) {
		return userTestDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserTest record) {
		return userTestDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserTest record) {
		return userTestDao.updateByPrimaryKey(record);
	}

	@Override
	public UserTest selectByName(String username) {
		return userTestDao.selectByName(username);
	}

}
