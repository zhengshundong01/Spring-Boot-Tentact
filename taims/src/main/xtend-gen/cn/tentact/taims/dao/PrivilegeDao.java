package cn.tentact.taims.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@SuppressWarnings("all")
public interface PrivilegeDao {
  public abstract List<Map> searchUserPrivilege(final String username);
}
