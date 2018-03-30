package cn.tentact.taims.dao;

import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@SuppressWarnings("all")
public interface UserDao {
  public abstract long login(final Map map);
}
