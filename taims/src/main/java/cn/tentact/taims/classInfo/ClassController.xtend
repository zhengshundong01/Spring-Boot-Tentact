package cn.tentact.taims.classInfo

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.annotation.Resource
import java.util.Map
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/class")
class ClassController {
	
	@Resource(name="classService")
	ClassService classService;
	
	@RequestMapping("/search/list")
	@ResponseBody
	def Map searchList(){
		var list = classService.searchList();
		return #{"result" -> list};
	}
	
	@RequestMapping("/search/page")
	@ResponseBody
	def Map searchPage(int start,int length){
		var list = classService.searchPage(start,length)
		return #{"result" -> list}
	}
	
	@RequestMapping("/search/count")
	@ResponseBody
	def Map searchCount(){
		var count = classService.searchCount;
		return #{"count" -> count}
	}
	
	@RequestMapping("/delete/id")
	@ResponseBody
	def Map deleteById(int id){
		classService.deleteById(id);
		return #{"result" -> true}
	}
	
	@RequestMapping("/delete/ids")
	@ResponseBody
	def Map deleteByIds(int[] ids){//asjx传过来的东西是一个数组
		classService.deleteByIds(ids);
		return #{"result" -> true}
	}
	
	@RequestMapping("/insert/info")
	@ResponseBody
	def Map insertStudent(String name, String major, String type, String state, int place_id){
		classService.insertStudent(name,major,type,state,place_id);
		return #{"result" -> true}
	}
	
	@RequestMapping("/update/info")
	@ResponseBody
	def Map updateClassInfo(int id,String name, String major, String type, String state, int place_id){
		println(type + "sasas")
		classService.updateClassInfo(id,name,major,type,state,place_id);	
		return #{"result" -> true}
	}
}