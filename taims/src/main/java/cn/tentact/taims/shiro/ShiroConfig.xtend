package cn.tentact.taims.shiro

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.apache.shiro.web.mgt.DefaultWebSecurityManager
import org.apache.shiro.spring.web.ShiroFilterFactoryBean

@Configuration
class ShiroConfig {
	
	@Bean
	def shirFilter(org.apache.shiro.mgt.SecurityManager manager){
		//创建ShiroFilterFactoryBean对象
		var factory= new ShiroFilterFactoryBean();
		factory.securityManager=manager;
		
		//定义登陆画面
		factory.loginUrl="login.html"
		//定义未授权提示画面
		factory.unauthorizedUrl = "/403.html"
		//定义登陆成功画面
		factory.successUrl = "/index.html"
		
		var map = #{
			"/img/**" -> "anon",//匿名
			"/js/**"  -> "anon",
			"/test/**" -> "anon",
			"/login.html" -> "anon",
			"/login.css" -> "anon",
			"/login.js" -> "anon",
			"/user/login" -> "anon",
//			"/student/info/search/Count" -> "authc,perms[0,5-4]",
//			"/student/info/search/Page" -> "authc,perms[0,5-4]",
//			"/student/info/delete/id" -> "authc,perms[0,5-2]",
//			"/student/info/delete/ids" -> "authc,perms[0,5-2]",
			"/**" -> "authc"//登陆访问
		}
		factory.filterChainDefinitionMap = map;
		return factory;
	}
	
	@Bean
	def securityManager(){//创建DefaultWebSecurityManager对象
		var securityManager= new DefaultWebSecurityManager();
		//设置realm
		securityManager.setRealm(new ShiroRealm);
		return securityManager
	}
}