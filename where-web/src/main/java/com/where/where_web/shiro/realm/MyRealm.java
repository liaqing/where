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

import com.where.where_web.shiro.dao.UserTestDao;
import com.where.where_web.shiro.entity.UserTest;


public class MyRealm extends AuthorizingRealm {
	@Resource
	private UserTestDao userTestDao;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
			System.out.println("执行方");
		  String username = (String) token.getPrincipal();
		 
		  
	        UserTest userTest = userTestDao.selectByName(username);
	        if (userTest == null) {
	            // 用户名不存在抛出异常
	            throw new UnknownAccountException();
	        }
	        
	        if (userTest.getLocked() == 0) {
	            // 用户被管理员锁定抛出异常
	            throw new LockedAccountException();
	        }
	        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userTest.getUsername(),
	                userTest.getPassword(), ByteSource.Util.bytes(userTest.getCredentialsSalt()), getName());
	        return authenticationInfo;

	
	}

	

}
