package com.where.where_web.business.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_web.business.dao.CommentsDao;
import com.where.where_web.business.model.Comments;

@Repository("commentsDao")
public class CommentsDaoImpl implements CommentsDao {
	@Inject
	private SqlSessionTemplate sqlSession;
			
	@Override
	public List<Comments> selectByUsersId(Integer usersId) {
		return sqlSession.selectList(Comments.class.getCanonicalName()+".selectByUsersId", usersId);
	}

	@Override
	public List<Comments> select() {
		return sqlSession.selectList(Comments.class.getName()+".select");
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(Comments.class.getName()+".deleteByPrimaryKey", id);
	}

	@Override
	public int insert(Comments comments) {
		return sqlSession.insert(Comments.class.getName()+".insert", comments);
	}

	@Override
	public int insertSelective(Comments comments) {
		return sqlSession.insert(Comments.class.getName()+".insertSelective", comments);
	}

	@Override
	public Comments selectByPrimaryKey(Integer id) {
		return sqlSession.selectOne(Comments.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public int updateByPrimaryKeySelective(Comments comments) {
		return sqlSession.update(Comments.class.getName()+".updateByPrimaryKeySelective", comments);
	}

	@Override
	public int updateByPrimaryKey(Comments comments) {
		return sqlSession.update(Comments.class.getName()+".updateByPrimaryKey", comments);
	}

	@Override
	public List<Comments> selectByShopId(Integer id) {
		return sqlSession.selectList(Comments.class.getName()+".selectByShopId", id);
	}

}
