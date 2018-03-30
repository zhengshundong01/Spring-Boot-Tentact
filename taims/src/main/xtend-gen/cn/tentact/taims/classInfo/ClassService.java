package cn.tentact.taims.classInfo;

import cn.tentact.taims.dao.ClassDao;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("classService")
@SuppressWarnings("all")
public class ClassService {
  @Autowired
  private ClassDao classDao;
  
  public List<Map> searchList() {
    List<Map> list = this.classDao.searchList();
    return list;
  }
  
  public List<Map> searchPage(final int start, final int length) {
    Pair<String, Integer> _mappedTo = Pair.<String, Integer>of("start", Integer.valueOf(start));
    Pair<String, Integer> _mappedTo_1 = Pair.<String, Integer>of("length", Integer.valueOf(length));
    Map<String, Integer> map = Collections.<String, Integer>unmodifiableMap(CollectionLiterals.<String, Integer>newHashMap(_mappedTo, _mappedTo_1));
    List<Map> list = this.classDao.searchPage(map);
    return list;
  }
  
  public long searchCount() {
    long count = this.classDao.searchCount();
    return count;
  }
  
  public void deleteById(final int id) {
    this.classDao.deleteById(id);
  }
  
  public void deleteByIds(final int[] ids) {
    Pair<String, int[]> _mappedTo = Pair.<String, int[]>of("ids", ids);
    Map<String, int[]> map = Collections.<String, int[]>unmodifiableMap(CollectionLiterals.<String, int[]>newHashMap(_mappedTo));
    this.classDao.deleteByIds(map);
  }
  
  public void insertStudent(final String name, final String major, final String type, final String state, final int place_id) {
    Pair<String, String> _mappedTo = Pair.<String, String>of("name", name);
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("major", major);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("type", type);
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("state", state);
    Pair<String, Integer> _mappedTo_4 = Pair.<String, Integer>of("place_id", Integer.valueOf(place_id));
    Map<String, Object> map = Collections.<String, Object>unmodifiableMap(CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4));
    InputOutput.<Map<String, Object>>println(map);
    this.classDao.insertStudent(map);
  }
  
  public void updateClassInfo(final int id, final String name, final String major, final String type, final String state, final int place_id) {
    Pair<String, Integer> _mappedTo = Pair.<String, Integer>of("id", Integer.valueOf(id));
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("name", name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("major", major);
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("type", type);
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("state", state);
    Pair<String, Integer> _mappedTo_5 = Pair.<String, Integer>of("place_id", Integer.valueOf(place_id));
    Map<String, Object> map = Collections.<String, Object>unmodifiableMap(CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5));
    InputOutput.<Map<String, Object>>println(map);
    this.classDao.updateClassInfo(map);
  }
}
