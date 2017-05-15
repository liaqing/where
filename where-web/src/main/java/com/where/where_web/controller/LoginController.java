package com.where.where_web.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.where.where_user_management.model.Administrator;
import com.where.where_user_management.model.Business;
import com.where.where_user_management.model.Users;
import com.where.where_user_management.service.BusinessService;
import com.where.where_user_management.service.UsersService;
import com.where.where_web.business.model.Shop;
import com.where.where_web.business.service.ShopService;
import com.where.where_web.shiro.test.CaptchaAuthenticationToken;
import com.where.where_web.shiro.test.LoginEnum;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Inject
	private ShopService shopService;
	@Inject
	private BusinessService businessService;
	
	@Inject
	private  UsersService usersService;
	@RequestMapping("/users")
	public ModelAndView userLogin(@Valid Users users,BindingResult result,@RequestParam(value="rememberMe",required=false) boolean rememberMe){
		
		ModelAndView mv=new ModelAndView("error");
		String username=users.getUsername();
		String password=users.getPassword();
		//UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		CaptchaAuthenticationToken token = new CaptchaAuthenticationToken(username, password,rememberMe);
		token.setLoginType(LoginEnum.users.toString());
		//token.setRememberMe(rememberMe);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (IncorrectCredentialsException ice) {
			mv.addObject("message", "username or password error!!");
			return mv;
		}catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
           
            mv.addObject("message", "username or password error!");
            return mv;
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
            mv.addObject("message", "times error");
            return mv;
        }catch(LockedAccountException lae){
            mv.addObject("message", "count locked");
            return mv;
        }
		users=usersService.selectByName(users);
		subject.getSession().setAttribute("users", users);
		return new ModelAndView("welcome");
	}
	//商家登录方法
	@RequestMapping("/business")
	public ModelAndView businessLogin(@Valid Business business,BindingResult result,@RequestParam(value="rememberMe",required=false) boolean rememberMe){
		ModelAndView mv=new ModelAndView("error");
		String username=business.getUsername();
		String password=business.getPassword();
		//UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		CaptchaAuthenticationToken token = new CaptchaAuthenticationToken(username, password,rememberMe);
		token.setLoginType(LoginEnum.business.toString());
		//token.setRememberMe(rememberMe);
		Subject subject = SecurityUtils.getSubject();
		
		try {
			subject.login(token);
		} catch (IncorrectCredentialsException ice) {
			mv.addObject("message", "username or password error!!");
			return mv;
		}catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
           
            mv.addObject("message", "username or password error!");
            return mv;
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
            mv.addObject("message", "times error");
            return mv;
        }catch(LockedAccountException lae){
            mv.addObject("message", "count locked");
            return mv;
        }catch (Throwable e) {
        	  mv.addObject("message", "count locked");
              return mv;
		}
		business=businessService.selectByName(business);
		subject.getSession().setAttribute("business", business);
		Shop shop=null;
		try {
			
			shop=shopService.selectByBusinessId(business.getId());
			if(shop==null){
				return new ModelAndView("");//跳转到创建店铺页面
			}
		} catch (Exception e) {
			return new ModelAndView("");//跳转到错误页面
		}
		subject.getSession().setAttribute("shop", shop);
		return new ModelAndView("business/index");
	}
	//管理员登录方法
	@RequestMapping("/administrator")
	public ModelAndView administratorLogin(@Valid Administrator administrator,BindingResult result,@RequestParam(value="rememberMe",required=false) boolean rememberMe){
		
		ModelAndView mv=new ModelAndView("error");
		String username=administrator.getUsername();
		String password=administrator.getPassword();
		//UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		CaptchaAuthenticationToken token = new CaptchaAuthenticationToken(username, password,rememberMe);
		token.setLoginType(LoginEnum.administrator.toString());
		//token.setRememberMe(rememberMe);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (IncorrectCredentialsException ice) {
			mv.addObject("message", "username or password error!!");
			return mv;
		}catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
           
            mv.addObject("message", "username or password error!");
            return mv;
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
            mv.addObject("message", "times error");
            return mv;
        }catch(LockedAccountException lae){
            mv.addObject("message", "count locked");
            return mv;
        }
		subject.getSession().setAttribute("administrator", administrator);
		System.out.println(subject.getSession().getId());
		return new ModelAndView("welcome");
	}
	
}
