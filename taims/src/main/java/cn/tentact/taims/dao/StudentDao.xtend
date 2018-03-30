package cn.tentact.taims.dao

import org.apache.ibatis.annotations.Mapper
import java.util.List
import java.util.Map

@Mapper
interface StudentDao {
	def long searchCount();
	
	def List<Map> searchPage(Map map);
	
	def void deleteById(int id);
	
	def void deleteByIds(Map map);
	
	def void insertStudent(Map map);
	
	def int searchPidCount(String pid);
	
	def void updateStudentInfo(Map map);
	
}