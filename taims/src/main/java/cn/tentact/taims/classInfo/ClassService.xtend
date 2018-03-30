package cn.tentact.taims.classInfo

import org.springframework.stereotype.Service
import cn.tentact.taims.dao.ClassDao
import org.springframework.beans.factory.annotation.Autowired
import java.util.List
import java.util.Map

@Service("classService")
class ClassService {
	@Autowired
	ClassDao classDao
	
	def List<Map> searchList(){
		var list = classDao.searchList();
		return list;
	}
	
	def List<Map> searchPage(int start,int length){
		var map = #{"start" -> start,"length" -> length};
		var list = classDao.searchPage(map)
		return list;
	}
	
	def long searchCount(){
		var count = classDao.searchCount;
		return count
	}
	
	def void deleteById(int id){
		classDao.deleteById(id);
	}
	
	def void deleteByIds(int[] ids){
		var map = #{"ids" ->ids};
		classDao.deleteByIds(map);
	}
	
	def void insertStudent(String name, String major, String type, String state, int place_id){
		//生日没有转换
		var map = #{
					"name"->name,
					"major" ->major,
					"type" ->type,
					"state" ->state,
					"place_id" ->place_id
		};
		println(map)
		classDao.insertStudent(map);
	}
	
	def void updateClassInfo(int id,String name, String major, String type, String state, int place_id){
		var map = #{"id" ->id,
					"name"->name,
					"major" ->major,
					"type" ->type,
					"state" ->state,
					"place_id" ->place_id
		};
		println(map)
		classDao.updateClassInfo(map);
	}
}