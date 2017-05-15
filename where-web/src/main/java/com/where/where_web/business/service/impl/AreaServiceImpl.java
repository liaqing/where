package com.where.where_web.business.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.where.where_web.business.dao.AreaDao;
import com.where.where_web.business.model.Area;
import com.where.where_web.business.service.AreaService;

@Service("areaService")
public class AreaServiceImpl implements AreaService {
	@Inject
	private AreaDao areaDao;
	
	@Override
	public Area selectByCode(Integer code) {
		return areaDao.selectByCode(code);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return areaDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Area area) {
		return areaDao.insert(area);
	}

	@Override
	public int insertSelective(Area area) {
		return areaDao.insertSelective(area);
	}

	@Override
	public Area selectByPrimaryKey(Integer id) {
		return areaDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Area area) {
		return areaDao.updateByPrimaryKeySelective(area);
	}

	@Override
	public int updateByPrimaryKey(Area area) {
		return areaDao.updateByPrimaryKey(area);
	}

}
