package cn.tentact.taims.place

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import cn.tentact.taims.dao.PlaceDao
import java.util.List
import java.util.Map

@Service("placeService")
class PlaceService {
	@Autowired
	PlaceDao placeDao
	
	def List<Map> searchList(){
		var list = placeDao.searchList();
		return list;
	}
	
	def List<Map> searchPage(int start,int length){
		var map = #{"start" -> start,"length" -> length};
		var list = placeDao.searchPage(map)
		return list;
	}
	
	def long searchCount(){
		var count = placeDao.searchCount;
		return count
	}
	
	def void deleteById(int id){
		placeDao.deleteById(id);
	}
	
	def void deleteByIds(int[] ids){
		var map = #{"ids" ->ids};
		placeDao.deleteByIds(map);
	}
	
	def void insertPlace(String name){
		//生日没有转换
		var map = #{
					"name"->name
		};
		println(map)
		placeDao.insertPlace(map);
	}
	
	def void updatePlaceInfo(int id,String name){
		var map = #{"id" ->id,
					"name"->name
		};
		println(map)
		placeDao.updatePlaceInfo(map);
	}
}