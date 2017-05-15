package com.where.where_web.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.where.where_user_management.model.Users;
import com.where.where_user_management.service.UsersService;

@Controller("userController")
@RequestMapping("/users")
public class UsersController {
	@Inject
	private UsersService usersService;
	
	/**
	 * 用于用户在注册时验证用户名的重复性
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/byUsername")
	public void byUsername(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String name=request.getParameter("username");
		Users users=new Users();
		users.setUsername(name);
		users=this.usersService.selectByName(users);
		if(users==null||""==users.getPassword()){
			response.getWriter().print(true);
		}else{
			response.getWriter().print(false);    
		}
		
	} 
	/**
	 * 用户注册方法,当result中错误的数量为0时，才能进行注册
	 * @param users
	 * @param result
	 * @return
	 */
	@RequestMapping("/register")
	public String register(@Valid @ModelAttribute Users users,BindingResult result){
		//System.out.println(result.getErrorCount());
		if(result.getErrorCount()!=0){
			return "usersRegister";
		}
		int isSuccess=usersService.insertSelective(users);
		if(isSuccess==0){//如果返回值为0，则成功插入数据
			return "failure";//跳转到失败页面
		}
		return "success";//跳转到成功页面
	}
	/**
	 * 该方法用于跳转用户登录页面，用于解决直接访问页面没有business对象,并把注册页面移到web-inf目录下
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/helper")
	public String usersHelp(Model model,HttpServletRequest request,HttpServletResponse response){
		//request.getRequestDispatcher("apage.jsp").forward(request, response);
		Users users=new Users();
		model.addAttribute("users", users);
		 //return "usersRegister";
		return "business/index";
	}
}
