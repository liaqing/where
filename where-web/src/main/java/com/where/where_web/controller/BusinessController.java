package com.where.where_web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.where.where_user_management.model.Business;
import com.where.where_user_management.service.BusinessService;

@Controller
@RequestMapping("/business")
public class BusinessController {
	@Inject
	private BusinessService businessService;
	/**
	 * 该方法用于商家在注册时验证用户名时是否存在
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/byUsername")
	public void byUsername(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String name=request.getParameter("username");
		Business business=new Business();
		business.setUsername(name);
		business=this.businessService.selectByName(business);
		if(business==null||""==business.getPassword()){
			response.getWriter().print(true);
		}else{
			response.getWriter().print(false);    
		}
		
	} 
	
	/**
	 * 该方法用于对商家进行注册
	 * @param business
	 * @param result
	 * @return
	 */
	@RequestMapping("/register")
	public String register(@Valid @ModelAttribute Business business,BindingResult result){
		System.out.println(result.getErrorCount());
		if(result.getErrorCount()!=0){
			return "usersRegister";
		}
		int isSuccess=businessService.insertSelective(business);
		if(isSuccess==0){//如果返回值为0，则插入数据失败
			return "failure";//跳转到失败页面
		}
		return "success";//跳转到成功页面
	}
	
	
	/**
	 * 该方法用于跳转商家登录页面，用于解决直接访问页面没有business对象,并把注册页面移到web-inf目录下
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/helper")
	public String usersHelp(Model model,HttpServletRequest request,HttpServletResponse response){
		//request.getRequestDispatcher("apage.jsp").forward(request, response);
		Business business=new Business();
		model.addAttribute("business", business);
		return "businessRegister";
	}
	
	@RequestMapping("/oldPasswordConfirm")
	@ResponseBody
	public void oldPasswordConfirm(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String algorithmName = "md5";
		int hashIterations = 2;
		String oldPassword=request.getParameter("oldPassword");//获取前台传来的密码
		
		Subject subject = SecurityUtils.getSubject();
		Business business=(Business)subject.getSession().getAttribute("business");//得到的session中当前登录的business
		business=businessService.selectByPrimaryKey(business.getId());
		String password=business.getPassword();//获取登录时的正确密码
		
		business.setPassword(oldPassword);//把前台传来的密码放到登录时的账号中，准备进行密码散列
		
		String oldPasswordEn = new SimpleHash(//获取散列后的密码
                algorithmName,
                business.getPassword(),
                ByteSource.Util.bytes(business.getCredentialsSalt()),
                hashIterations).toHex();
		
	
		if(password.equals(oldPasswordEn)){//判断原密码是否和前台密码一致
			response.getWriter().print(true);
		}else{
			response.getWriter().print(false);    
		}
		
	
	} 
	
	@RequestMapping("/updatePassword")
	public String updatePassword(String newPassword){
		String algorithmName = "md5";
		int hashIterations = 2;
		try {
			Subject subject = SecurityUtils.getSubject();
			Business business = (Business) subject.getSession().getAttribute("business");//得到的session中当前登录的business
			business.setPassword(newPassword);//把前台传来的新密码放到登录时的账号中，准备进行密码散列
			String newPasswordEn = new SimpleHash(//获取散列后的密码
					algorithmName, business.getPassword(), ByteSource.Util.bytes(business.getCredentialsSalt()),
					hashIterations).toHex();
			Business newBusiness = new Business();
			newBusiness.setId(business.getId());
			newBusiness.setPassword(newPasswordEn);
			int isSuccess = businessService.updateByPrimaryKeySelective(newBusiness);
			if (isSuccess == 0) {
				return "error";
			} 
		} catch (Exception e) {
			return "error";
		}
		return "business/password/updatePasswordSuccess";
	}
	
	@RequestMapping("/updatePasswordHelper")
	public  String updatePasswordHelper(){
		return "business/password/updatePassword";
	}
	
	
	@RequestMapping("/selectBusiness")
	public String selectBusiness(Model model){
		Subject subject = SecurityUtils.getSubject();
		Business business=(Business)subject.getSession().getAttribute("business");
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String birthdayStr=simpleDateFormat.format(business.getBirthday());
		business.setBirthdayStr(birthdayStr);
		model.addAttribute("business", business);
		return "business/selectBusiness";
		
	}
}
