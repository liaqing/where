package com.where.where_web.business.dao;

import java.util.List;

import com.where.where_web.business.model.Comments;

public interface CommentsDao {
	
	public List<Comments> selectByUsersId(Integer usersId);
	
	public List<Comments> select();
	
    public int deleteByPrimaryKey(Integer id);

    public int insert(Comments comments);

    public int insertSelective(Comments comments);

    public Comments selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Comments comments);

    public int updateByPrimaryKey(Comments comments);
    
    public List<Comments> selectByShopId(Integer id);
}