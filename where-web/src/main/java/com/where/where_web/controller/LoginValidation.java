package com.where.where_web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.where.where_user_management.service.UsersService;

@Controller
@RequestMapping("/validate")
public class LoginValidation {
	@Resource
	private UsersService usersService;
	
	public String usersValidate(){
		return "";
	}
	
}
