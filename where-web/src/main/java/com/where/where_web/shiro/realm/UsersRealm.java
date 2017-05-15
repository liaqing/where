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

import com.where.where_user_management.model.Users;
import com.where.where_user_management.service.UsersService;


public class UsersRealm extends AuthorizingRealm {
	@Resource
	private UsersService usersService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
			System.out.println("执行方usersRealm");
		  String username = (String) token.getPrincipal();
		  Users users =new Users();
		  users.setUsername(username);
	        users = usersService.selectByName(users);
	        if (users == null) {
	            // 用户名不存在抛出异常
	            throw new UnknownAccountException();
	        }
	        
	        if (users.getIslocked() == 0) {
	            // 用户被管理员锁定抛出异常
	            throw new LockedAccountException();
	        }
	        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(users.getUsername(),
	                users.getPassword(), ByteSource.Util.bytes(users.getCredentialsSalt()), getName());
	        return authenticationInfo;

	
	}

	

}
