package cn.tentact.taims.dao

import org.apache.ibatis.annotations.Mapper
import java.util.List
import java.util.Map

@Mapper
interface PrivilegeDao {
	def List<Map> searchUserPrivilege(String username);
}