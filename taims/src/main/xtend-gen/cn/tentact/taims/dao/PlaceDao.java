package cn.tentact.taims.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@SuppressWarnings("all")
public interface PlaceDao {
  public abstract List<Map> searchList();
  
  public abstract List<Map> searchPage(final Map map);
  
  public abstract long searchCount();
  
  public abstract void deleteById(final int id);
  
  public abstract void deleteByIds(final Map map);
  
  public abstract void insertPlace(final Map map);
  
  public abstract void updatePlaceInfo(final Map map);
}
