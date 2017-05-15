package com.where.where_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/l")
public class L {
	@RequestMapping("/login")
	public String login(){
		return "business/addFood";
	}
}
