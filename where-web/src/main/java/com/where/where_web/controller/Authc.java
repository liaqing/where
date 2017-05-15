package com.where.where_web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.where.where_web.shiro.entity.UserTest;

@Controller
@RequestMapping("/authc")
public class Authc {
	@RequestMapping("/login")
	public String login(){
		
		Subject subject = SecurityUtils.getSubject();
		Session session=subject.getSession();
		UserTest userTest=(UserTest)session.getAttribute("user");
		System.out.println(userTest.getUsername());
		System.out.println(session.getId());
		return "success";
	}
}
