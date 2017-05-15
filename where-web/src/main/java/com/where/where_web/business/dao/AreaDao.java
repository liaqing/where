package com.where.where_web.business.dao;

import com.where.where_web.business.model.Area;

public interface AreaDao {
	Area selectByCode(Integer code);
	
    int deleteByPrimaryKey(Integer id);

    int insert(Area area);

    int insertSelective(Area area);

    Area selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Area area);

    int updateByPrimaryKey(Area area);
}