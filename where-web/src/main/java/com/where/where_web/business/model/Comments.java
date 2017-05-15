package com.where.where_web.business.model;

import java.io.Serializable;
import java.text.ParseException;

import com.where.where_user_management.model.Users;

public class Comments implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String content;

    private Users users;

    private String commentTime;
    
    private Integer shopId;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    
    

    public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getCommentTime() throws ParseException {
		
        return commentTime;
    }

    public void setCommentTime(String commentTime) throws ParseException {
    	
		
    	
        this.commentTime = commentTime;
    }

    	
	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", content=" + content + ", users=" + users + ", commentTime=" + commentTime
				+ ", shopId=" + shopId + "]";
	}

	
    
    
    
}