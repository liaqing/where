package com.where.where_web.shiro.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.where.where_user_management.model.Business;
import com.where.where_user_management.service.BusinessService;


public class BusinessRealm extends AuthorizingRealm {
	@Resource
	private BusinessService businessService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
			System.out.println("执行方businessRealm");
		  String username = (String) token.getPrincipal();
		  Business business=new Business();
		  business.setUsername(username);
	        business = businessService.selectByName(business);
	        if (business == null) {
	            // 用户名不存在抛出异常
	            throw new UnknownAccountException();
	        }
	        
	        if (business.getIslocked() == 0) {
	        	System.out.println("商家被锁定");
	            // 用户被管理员锁定抛出异常
	            throw new LockedAccountException();
	        }
	        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(business.getUsername(),
	                business.getPassword(), ByteSource.Util.bytes(business.getCredentialsSalt()), getName());
	        return authenticationInfo;

	
	}

	

}
