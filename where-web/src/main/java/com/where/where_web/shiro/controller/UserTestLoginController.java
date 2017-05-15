package com.where.where_web.shiro.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.where.where_web.shiro.entity.UserTest;
import com.where.where_web.shiro.service.UserTestService;

@Controller
@RequestMapping("/userTest")
public class UserTestLoginController {
	 	@Resource
	 	
	    private UserTestService userTestService;

	    @RequestMapping("/login")
	    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam(value="rememberMe",required=false) boolean rememberMe ) {
	       
	    	System.out.println("jjjj");
	    	UsernamePasswordToken token = new UsernamePasswordToken(username, password);
	    	token.setRememberMe(rememberMe);
	    	Subject subject=SecurityUtils.getSecurityManager().createSubject(new DefaultSubjectContext());
	        try {
	        	Session session = subject.getSession();
	        	if(session != null){
	        		
	        		System.out.println(session.getAttribute("key"));
	        		System.out.println(session.getId());
	        		System.out.println(session.getHost());
	        		System.out.println(session.getTimeout());
	        	}
	            subject.login(token);
	        } catch (IncorrectCredentialsException ice) {
	            // 捕获密码错误异常
	            ModelAndView mv = new ModelAndView("error");
	            mv.addObject("message", "password error!");
	            return mv;
	        } catch (UnknownAccountException uae) {
	            // 捕获未知用户名异常
	            ModelAndView mv = new ModelAndView("error");
	            mv.addObject("message", "username error!");
	            return mv;
	        } catch (ExcessiveAttemptsException eae) {
	            // 捕获错误登录过多的异常
	            ModelAndView mv = new ModelAndView("error");
	            mv.addObject("message", "times error");
	            return mv;
	        }catch(LockedAccountException lae){
	        	ModelAndView mv = new ModelAndView("error");
	            mv.addObject("message", "count locked");
	            return mv;
	        }
	        UserTest userTest = userTestService.selectByName(username);
	        subject.getSession().setAttribute("user", userTest);
	        ModelAndView modelAndView=new ModelAndView("test");
	       
	        return modelAndView;
	    }
}
