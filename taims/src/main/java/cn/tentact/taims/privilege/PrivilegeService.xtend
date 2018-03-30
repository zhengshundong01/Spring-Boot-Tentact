package cn.tentact.taims.privilege

import org.springframework.stereotype.Service
import java.util.List
import java.util.Map
import org.springframework.beans.factory.annotation.Autowired
import cn.tentact.taims.dao.PrivilegeDao

@Service("privilegeService")
class PrivilegeService {
	@Autowired
	PrivilegeDao privilegeDao;
	 
	def List<Map> searchUserPrivilege(String username){
		var list = privilegeDao.searchUserPrivilege(username);
		return list;
	}
}