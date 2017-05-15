package com.where.where_web.shiro.test;

import org.apache.shiro.authc.UsernamePasswordToken;

public class CaptchaAuthenticationToken extends UsernamePasswordToken {
	/**
	 * 继承usernamepasswordToken，实现两端登录
	 */
	
	private static final long serialVersionUID = 1L;
	private String loginType;
	public CaptchaAuthenticationToken(String username, String password, boolean rememberMe) {
		super(username, password, rememberMe);
		
	}
	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
}
