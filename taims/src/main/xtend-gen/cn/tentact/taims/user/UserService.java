package cn.tentact.taims.user;

import cn.tentact.taims.dao.UserDao;
import java.util.Collections;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
@SuppressWarnings("all")
public class UserService {
  @Autowired
  private UserDao userDao;
  
  public boolean login(final String username, final String password) {
    Pair<String, String> _mappedTo = Pair.<String, String>of("username", username);
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("password", password);
    Map<String, String> map = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1));
    long count = this.userDao.login(map);
    if ((count == 1)) {
      return true;
    } else {
      return false;
    }
  }
}
