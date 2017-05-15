package com.where.where_web.shiro.controller;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.where.where_web.shiro.entity.UserTest;

@Controller  
@RequestMapping("/test")  
public class SpringTest {
	/*@Inject
	 private UserTestService userTestService;
	*/
	  
	  @RequestMapping("/login")
	public String login(@Valid @ModelAttribute("userTest") UserTest userTest,/*Model model,*/BindingResult result){
		  //errors.rejectValue("username", "错误信息");
		 if(userTest.getPassword().equals("")){  //注意：如果输入框中没有值，后台的到的是""，而不是null，在验证的时候@notNull便不会起作用
			 System.out.println("bushi ");
			 userTest.setPassword(null);
		 }
		 Subject subject = SecurityUtils.getSubject();
		 Session session=subject.getSession();
		 System.out.println(session.getId());
		 System.out.println(session.getTimeout());
		 //session.setAttribute("key", "cesjh");
		System.out.println(session.getAttribute("key"));
		 
		 // System.out.println(userTest.getUsername());
		  //System.out.println(userTest.getPassword());
		 // model.addAttribute("userTest", userTest);
		 //model.addAttribute("result", result);
		return "test";
	}
}
