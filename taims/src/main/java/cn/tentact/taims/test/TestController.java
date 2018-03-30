package cn.tentact.taims.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.BasicDBObject;

@Controller
@RequestMapping("/test")	//分配的目录,类地址
public class TestController {
	@Autowired
	MongoTemplate template;
	
	@RequestMapping("/register")//可以对网络访问，方法的地址
	public String register(String loginname,String loginpwd) {
//		public String register(String username,String password,String sex) {
//		System.out.println(username+password+sex);
		System.out.println(loginname + loginpwd);
		return "redirect:/AngularJS/html/index.html";//跳转
//		return "redirect:/test/2.html";//跳转
	}
	@RequestMapping("/add")
	@ResponseBody
	public Map add(String title,String content) {
		BasicDBObject obj = new BasicDBObject();
		obj.put("title", title);
		obj.put("content", content);
		template.save(obj,"news");
		HashMap map = new HashMap<>();
		map.put("result", "ok");
		return map;
	}
	
	@RequestMapping("/remove")
	@ResponseBody
	public Map add(String title) {
		Query query = new Query();
		query.addCriteria(Criteria.where("title"));
		template.remove(query, "news");
		HashMap map = new HashMap<>();
		map.put("result", "ok");
		return map;
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public Map searchPage(long start,int length) {
		Query query = new Query();
		query.skip(start);
		query.limit(length);
		List<HashMap> list = template.find(query,HashMap.class,"news");
		HashMap map = new HashMap<>();
		map.put("result", list);
		return map;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Map update(String title) {
		Query query = new Query();
		Update update = new Update();
		update.set("title",title);
		template.updateMulti(query, update, "news");
		HashMap map = new HashMap<>();
		map.put("result", "ok");
		return map;
	}
}
