package cn.tentact.taims.dao

import org.apache.ibatis.annotations.Mapper
import java.util.Map

@Mapper
interface UserDao {
	def long login(Map map);
}