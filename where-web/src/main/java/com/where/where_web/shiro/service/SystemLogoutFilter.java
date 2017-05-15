package com.where.where_web.shiro.service;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;

public class SystemLogoutFilter extends LogoutFilter {

	

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		
		Subject subject = getSubject(request, response);

        String redirectUrl = getRedirectUrl(request, response, subject);

        try {
        	
        	System.out.println(redirectUrl);
            subject.logout();

        } catch (SessionException ise) {

           ise.printStackTrace();

        }
        //此处固定为该页面
        issueRedirect(request,response,"/businessLogin.jsp");

        return false;
	}
	
}
