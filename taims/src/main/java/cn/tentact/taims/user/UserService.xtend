package cn.tentact.taims.user

import org.springframework.stereotype.Service
import cn.tentact.taims.dao.UserDao
import org.springframework.beans.factory.annotation.Autowired

@Service("userService")
class UserService {
	@Autowired
	UserDao userDao
	
	def boolean login(String username,String password){
//		var map = new HashMap();
		var map = #{"username"-> username, "password"-> password}
		var count = userDao.login(map);
		if (count == 1) {
			return true;
		}else{
			return false;
		}
	}
}