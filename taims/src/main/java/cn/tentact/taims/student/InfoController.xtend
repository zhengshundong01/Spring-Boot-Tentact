package cn.tentact.taims.student

import javax.annotation.Resource
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import java.util.Map
import org.springframework.web.bind.annotation.ResponseBody
import java.util.List

@Controller
@RequestMapping("/student/info")
class InfoController {
	@Resource(name = "infoService")
	InfoService infoService
	
	@RequestMapping("/search/Count")
	@ResponseBody
	def Map searchCount(){
		var count = infoService.searchCount();
		return #{"count" -> count};
	}
	
	@RequestMapping("/search/Page")
	@ResponseBody
	def Map searchPage(int start,int length){
		var list = infoService.searchPage(start,length);
		return #{"result" -> list}
	}
	
	@RequestMapping("/delete/id")
	@ResponseBody
	def Map deleteById(int id){
		infoService.deleteById(id);
		return #{"result" -> true}
	}
	
	@RequestMapping("/delete/ids")
	@ResponseBody
	def Map deleteByIds(int[] ids){//asjx传过来的东西是一个数组
		infoService.deleteByIds(ids);
		return #{"result" -> true}
	}
	
	@RequestMapping("/insert/info")
	@ResponseBody
	def Map insertStudent(String name,String sex,String birthday,int class_id,String tel,String pid,String school,String major,int year,String state){
//		println(name+sex+birthday+class_id+tel+pid+school+major+year+state)
		infoService.insertStudent(name,sex,birthday,class_id,tel,pid,school,major,year,state);
		return #{"result" -> true}
	}
	
	@RequestMapping("/search/pidCount")
	@ResponseBody
	def Map searchPidCount(String pid){
		var bool = infoService.searchPidCount(pid);
		return #{"result" -> bool}
	}
	
	@RequestMapping("/update/info")
	@ResponseBody
	def Map updateStudentInfo(int id,String name,String sex,String birthday,int class_id,String tel,String pid,String school,String major,int year,String state){
		infoService.updateStudentInfo(id,name,sex,birthday,class_id,tel,pid,school,major,year,state);	
		return #{"result" -> true}
	}
}