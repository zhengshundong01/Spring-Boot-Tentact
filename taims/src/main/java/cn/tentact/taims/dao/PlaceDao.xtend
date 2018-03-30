package cn.tentact.taims.dao

import org.apache.ibatis.annotations.Mapper
import java.util.List
import java.util.Map

@Mapper
interface PlaceDao {
	
	def List<Map> searchList();
	
	def List<Map> searchPage(Map map);
	
	def long searchCount();
	
	def void deleteById(int id);
	
	def void deleteByIds(Map map);
	
	def void insertPlace(Map map);
	
	def void updatePlaceInfo(Map map);
}