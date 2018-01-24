package com.yinzifan.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.yinzifan.entity.UserInfoEntity;
import com.yinzifan.service.UserInfoService;

/**
* @author Cin
* @time 2018/01/23 23:05:15
* 自定义Realm
*/
public class MyRealm extends AuthorizingRealm{
	@Autowired
	private UserInfoService userInfoService;
	/**
	 * 为当前登录的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * 验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UserInfoEntity userInfo = userInfoService.queryUserInfoByUserName(token.getPrincipal().toString());
		if(userInfo == null) return null;
		else {
			SecurityUtils.getSubject().getSession().setAttribute("loginUserInfo", userInfo);
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo.getUserName(), userInfo.getPassword(), userInfo.getUserName());
			return authenticationInfo;
		}
	}
	
}
