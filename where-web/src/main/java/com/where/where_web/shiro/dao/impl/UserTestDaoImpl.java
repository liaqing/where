package com.where.where_web.shiro.dao.impl;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_web.shiro.dao.UserTestDao;
import com.where.where_web.shiro.entity.UserTest;

@Repository("userTestDao")
public class UserTestDaoImpl implements UserTestDao {
	@Inject
	private  SqlSessionTemplate sqlSession;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(UserTest.class.getName()+".deleteByPrimaryKey", id);
	}

	@Override
	public int insert(UserTest record) {
		return sqlSession.insert(UserTest.class.getName()+".insert", record);
		
	}

	@Override
	public int insertSelective(UserTest record) {
		
		return sqlSession.insert(UserTest.class.getName()+".insertSelective", record);
	}

	@Override
	public UserTest selectByPrimaryKey(Integer id) {
		
		return sqlSession.selectOne(UserTest.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserTest record) {
		
		return sqlSession.update(UserTest.class.getName()+".updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(UserTest record) {
		
		return sqlSession.update(UserTest.class.getName()+".updateByPrimaryKey", record);
	}

	@Override
	public UserTest selectByName(String username) {
		return sqlSession.selectOne(UserTest.class.getName()+".selectByName", username);
	}

}
