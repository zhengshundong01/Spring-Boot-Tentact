package cn.tentact.taims.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@SuppressWarnings("all")
public interface StudentDao {
  public abstract long searchCount();
  
  public abstract List<Map> searchPage(final Map map);
  
  public abstract void deleteById(final int id);
  
  public abstract void deleteByIds(final Map map);
  
  public abstract void insertStudent(final Map map);
  
  public abstract int searchPidCount(final String pid);
  
  public abstract void updateStudentInfo(final Map map);
}
