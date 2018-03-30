package cn.tentact.taims.place

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.annotation.Resource
import org.springframework.web.bind.annotation.ResponseBody
import java.util.Map
import java.util.List

@Controller
@RequestMapping("/place")
class PlaceController {
	@Resource(name = "placeService")
	PlaceService placeService
	
	@RequestMapping("/search/list")
	@ResponseBody
	def Map searchList(){
		var list = placeService.searchList();
		return #{"result" -> list};
	}
	
	@RequestMapping("/search/page")
	@ResponseBody
	def Map searchPage(int start,int length){
		var list = placeService.searchPage(start,length)
		return #{"result" -> list}
	}
	
	@RequestMapping("/search/count")
	@ResponseBody
	def Map searchCount(){
		var count = placeService.searchCount;
		return #{"count" -> count}
	}
	
	@RequestMapping("/delete/id")
	@ResponseBody
	def Map deleteById(int id){
		placeService.deleteById(id);
		return #{"result" -> true}
	}
	
	@RequestMapping("/delete/ids")
	@ResponseBody
	def Map deleteByIds(int[] ids){//asjx传过来的东西是一个数组
		placeService.deleteByIds(ids);
		return #{"result" -> true}
	}
	
	@RequestMapping("/insert/info")
	@ResponseBody
	def Map insertPlace(String name){
		placeService.insertPlace(name);
		return #{"result" -> true}
	}
	
	@RequestMapping("/update/info")
	@ResponseBody
	def Map updatePlaceInfo(int id,String name){
		placeService.updatePlaceInfo(id,name);	
		return #{"result" -> true}
	}
}