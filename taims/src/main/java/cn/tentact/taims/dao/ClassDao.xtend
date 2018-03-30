package cn.tentact.taims.dao

import org.apache.ibatis.annotations.Mapper

import java.util.Map
import java.util.List

@Mapper
interface ClassDao {
	def List<Map> searchList();
	
	def List<Map> searchPage(Map map);
	
	def long searchCount();
	
	def void deleteById(int id);
	
	def void deleteByIds(Map map);
	
	def void insertStudent(Map map);
	
	def void updateClassInfo(Map map);
}