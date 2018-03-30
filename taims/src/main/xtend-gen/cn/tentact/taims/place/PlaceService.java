package cn.tentact.taims.place;

import cn.tentact.taims.dao.PlaceDao;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("placeService")
@SuppressWarnings("all")
public class PlaceService {
  @Autowired
  private PlaceDao placeDao;
  
  public List<Map> searchList() {
    List<Map> list = this.placeDao.searchList();
    return list;
  }
  
  public List<Map> searchPage(final int start, final int length) {
    Pair<String, Integer> _mappedTo = Pair.<String, Integer>of("start", Integer.valueOf(start));
    Pair<String, Integer> _mappedTo_1 = Pair.<String, Integer>of("length", Integer.valueOf(length));
    Map<String, Integer> map = Collections.<String, Integer>unmodifiableMap(CollectionLiterals.<String, Integer>newHashMap(_mappedTo, _mappedTo_1));
    List<Map> list = this.placeDao.searchPage(map);
    return list;
  }
  
  public long searchCount() {
    long count = this.placeDao.searchCount();
    return count;
  }
  
  public void deleteById(final int id) {
    this.placeDao.deleteById(id);
  }
  
  public void deleteByIds(final int[] ids) {
    Pair<String, int[]> _mappedTo = Pair.<String, int[]>of("ids", ids);
    Map<String, int[]> map = Collections.<String, int[]>unmodifiableMap(CollectionLiterals.<String, int[]>newHashMap(_mappedTo));
    this.placeDao.deleteByIds(map);
  }
  
  public void insertPlace(final String name) {
    Pair<String, String> _mappedTo = Pair.<String, String>of("name", name);
    Map<String, String> map = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo));
    InputOutput.<Map<String, String>>println(map);
    this.placeDao.insertPlace(map);
  }
  
  public void updatePlaceInfo(final int id, final String name) {
    Pair<String, Integer> _mappedTo = Pair.<String, Integer>of("id", Integer.valueOf(id));
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("name", name);
    Map<String, Object> map = Collections.<String, Object>unmodifiableMap(CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1));
    InputOutput.<Map<String, Object>>println(map);
    this.placeDao.updatePlaceInfo(map);
  }
}
