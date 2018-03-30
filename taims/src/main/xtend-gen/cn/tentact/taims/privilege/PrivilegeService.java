package cn.tentact.taims.privilege;

import cn.tentact.taims.dao.PrivilegeDao;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("privilegeService")
@SuppressWarnings("all")
public class PrivilegeService {
  @Autowired
  private PrivilegeDao privilegeDao;
  
  public List<Map> searchUserPrivilege(final String username) {
    List<Map> list = this.privilegeDao.searchUserPrivilege(username);
    return list;
  }
}
