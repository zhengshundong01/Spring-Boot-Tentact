package cn.tentact.taims.student

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import cn.tentact.taims.dao.StudentDao
import java.util.List
import java.util.Map

@Service("infoService")
class InfoService {
	@Autowired
	StudentDao studentDao
	
	def long searchCount(){
		var count = studentDao.searchCount();
		return count;
	}
	
	def List<Map> searchPage(int start,int length){
		var map = #{"start" -> start , "length" -> length};
		var list = studentDao.searchPage(map);
		return list;
	}
	
	def void deleteById(int id){
		studentDao.deleteById(id);
	}
	
	def void deleteByIds(int[] ids){
		var map = #{"ids" ->ids};
		studentDao.deleteByIds(map);
	}
	
	def void insertStudent(String name,String sex,String birthday,int class_id,String tel,String pid,String school,String major,int year,String state){
		//生日没有转换
		var map = #{"name"->name,
					"sex" ->sex,
					"birthday" ->birthday,
					"class_id" ->class_id,
					"tel" ->tel,
					"pid" ->pid,
					"school" ->school,
					"major" ->major,
					"year" ->year,
					"state" ->state
		};
		studentDao.insertStudent(map);
	}
	
	def boolean searchPidCount(String pidInfo){
		var count = studentDao.searchPidCount(pidInfo);
		if (count > 0) {
			return true;
		}
		return false;
	}
	
	def void updateStudentInfo(int id,String name,String sex,String birthday,int class_id,String tel,String pid,String school,String major,int year,String state){
		var map = #{"id" ->id,
					"name"->name,
					"sex" ->sex,
					"birthday" ->birthday,
					"class_id" ->class_id,
					"tel" ->tel,
					"pid" ->pid,
					"school" ->school,
					"major" ->major,
					"year" ->year,
					"state" ->state
		};
		studentDao.updateStudentInfo(map);
	}
}