package cn.tentact.taims.shiro

import org.apache.shiro.realm.AuthorizingRealm
import org.apache.shiro.subject.PrincipalCollection
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.authc.SimpleAuthenticationInfo
import org.apache.shiro.SecurityUtils
import org.apache.shiro.authz.SimpleAuthorizationInfo
import java.util.List

class ShiroRealm extends AuthorizingRealm{
	/**
	 * 授权方法
	 */
	override protected doGetAuthorizationInfo(PrincipalCollection arg0) {
		var subject = SecurityUtils.subject;//获得会话对象
		var session=subject.session//获得Shiro的Session
		var list = session.getAttribute("privilege") as List;//从Shrio的session中国获得权限
		
		var info = new SimpleAuthorizationInfo();//创建授权对象
		info.addStringPermissions(list);//把权限保存到授权对象
		return info//返回授权对象，将该对象写入到HTTP session
	}
	/**
	 * 认证方法
	 */
	 
	  
	override protected doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获得token中的用户名和密码
		var tk = token as UsernamePasswordToken;
		var username = tk.username;
		var password = new String(tk.password);
		//把用户名密码封装认证对象
		var info = new SimpleAuthenticationInfo(username,password,name);
		//返回认证对象，该对象会写入到HTTPSession，实现认证
		return info;
	
	}
}