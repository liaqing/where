package com.where.where_web.business.dao.impl;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_web.business.dao.AreaDao;
import com.where.where_web.business.model.Area;

@Repository("areaDao")
public class AreaDaoImpl implements AreaDao {
	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Area selectByCode(Integer code) {
		return sqlSession.selectOne(Area.class.getName()+".selectByCode", code);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(Area.class.getName()+".deleteByPrimaryKey", id);
	}

	@Override
	public int insert(Area area) {
		return sqlSession.insert(Area.class.getName()+".insert", area);
	}

	@Override
	public int insertSelective(Area area) {
		return sqlSession.insert(Area.class.getName()+".insertSelective", area);
	}

	@Override
	public Area selectByPrimaryKey(Integer id) {
		return sqlSession.selectOne(Area.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(Area area) {
		return sqlSession.update(Area.class.getName()+".updateByPrimaryKeySelective", area);
	}

	@Override
	public int updateByPrimaryKey(Area area) {
		return sqlSession.update(Area.class.getName()+".updateByPrimaryKey", area);
	}

}
