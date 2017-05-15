package com.where.where_web.business.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.where.where_web.business.dao.CommentsDao;
import com.where.where_web.business.model.Comments;
import com.where.where_web.business.service.CommentsService;

@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {
	@Inject
	private CommentsDao commentsDao;
	
	@Override
	public List<Comments> selectByUsersId(Integer usersId) {
		return commentsDao.selectByUsersId(usersId);
	}

	@Override
	public List<Comments> select() {
		return commentsDao.select();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return commentsDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Comments comments) {
		return commentsDao.insert(comments);
	}

	@Override
	public int insertSelective(Comments comments) {
		return commentsDao.insertSelective(comments);
	}

	@Override
	public Comments selectByPrimaryKey(Integer id) {
		return commentsDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Comments comments) {
		return commentsDao.updateByPrimaryKeySelective(comments);
	}

	@Override
	public int updateByPrimaryKey(Comments comments) {
		return commentsDao.updateByPrimaryKey(comments);
	}

	@Override
	public List<Comments> selectByShopId(Integer id) {
		return commentsDao.selectByShopId(id);
	}

}
