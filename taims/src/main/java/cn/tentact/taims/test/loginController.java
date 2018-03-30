package cn.tentact.taims.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logincontroller")	//分配的目录,类地址
public class loginController {
	
	@RequestMapping("/login")//可以对网络访问，方法的地址
	public String login(String loginname,String loginpwd) {
		System.out.println(loginname+loginpwd);
		return "redirect:/AngularJS/html/index.html";//跳转
	}
}
