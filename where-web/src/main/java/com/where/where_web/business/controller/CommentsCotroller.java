package com.where.where_web.business.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.where.where_web.business.model.Comments;
import com.where.where_web.business.model.Shop;
import com.where.where_web.business.service.CommentsService;

@Controller
@RequestMapping("/comments")
public class CommentsCotroller {
	@Inject
	private CommentsService  commentsService;
	
	@RequestMapping("/select")
	@ResponseBody
	public String select(){
		Subject subject = SecurityUtils.getSubject();
		Shop shop=(Shop)subject.getSession().getAttribute("shop");
		if(shop==null){
			return "";
		}
		List<Comments> list=commentsService.selectByShopId(shop.getId());
		Gson gson=new Gson();
		String json=gson.toJson(list);
		return json;
	}
	
	@RequestMapping("deleteComments")
	@ResponseBody
	public String deleteComments(@RequestParam Integer id){
		try {
			int isSuccess=commentsService.deleteByPrimaryKey(id);
			if(isSuccess==0){
				return "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
		return "1";
	}
	
	@RequestMapping("/selectHelper")
	public String lookCommentsHelper(){
		return "business/comments/findComments";
	}
	
	@RequestMapping("lookComments")
	public String lookComments(Integer id,Model model){
		Comments comments=commentsService.selectByPrimaryKey(id);
		model.addAttribute("comments", comments);
		return "business/comments/lookComments";
	}
	
}
