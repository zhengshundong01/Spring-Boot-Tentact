package cn.tentact.taims.user

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.annotation.Resource
import cn.tentact.taims.privilege.PrivilegeService
import org.springframework.web.bind.annotation.ResponseBody
import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.UsernamePasswordToken

@Controller
@RequestMapping("/user")//网址
class UserController {
	@Resource(name="userService")//有传入值
	UserService userService;
	
	@Resource(name="privilegeService")
	PrivilegeService privilegeService;
	
	@RequestMapping("/login")
//	@ResponseBody	//如果界面不跳转，只是返回字符串加这个
	def String login(String username,String password){
		var bool = userService.login(username,password);
		if (bool) {
			var list = privilegeService.searchUserPrivilege(username);
			//添加Shiro操作，执行认证和授权函数
			var subject = SecurityUtils.subject;//Shiro执行的接口
			var session=subject.session;//Shiro的Session对象用于向Realm传输数据
			session.setAttribute("privilege",list)//把权限列表保存到Shiro的Session
			var token = new UsernamePasswordToken(username,password);//创建令牌对象，
			subject.login(token);//执行login函数，Shiro就会调用Realm类里面的认证函数
			 
			return "redirect:/index.html"
		}else{
			return "redirect:/login.html"
		}
	}
}