package cn.tentact.taims.student;

import cn.tentact.taims.dao.StudentDao;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("infoService")
@SuppressWarnings("all")
public class InfoService {
  @Autowired
  private StudentDao studentDao;
  
  public long searchCount() {
    long count = this.studentDao.searchCount();
    return count;
  }
  
  public List<Map> searchPage(final int start, final int length) {
    Pair<String, Integer> _mappedTo = Pair.<String, Integer>of("start", Integer.valueOf(start));
    Pair<String, Integer> _mappedTo_1 = Pair.<String, Integer>of("length", Integer.valueOf(length));
    Map<String, Integer> map = Collections.<String, Integer>unmodifiableMap(CollectionLiterals.<String, Integer>newHashMap(_mappedTo, _mappedTo_1));
    List<Map> list = this.studentDao.searchPage(map);
    return list;
  }
  
  public void deleteById(final int id) {
    this.studentDao.deleteById(id);
  }
  
  public void deleteByIds(final int[] ids) {
    Pair<String, int[]> _mappedTo = Pair.<String, int[]>of("ids", ids);
    Map<String, int[]> map = Collections.<String, int[]>unmodifiableMap(CollectionLiterals.<String, int[]>newHashMap(_mappedTo));
    this.studentDao.deleteByIds(map);
  }
  
  public void insertStudent(final String name, final String sex, final String birthday, final int class_id, final String tel, final String pid, final String school, final String major, final int year, final String state) {
    Pair<String, String> _mappedTo = Pair.<String, String>of("name", name);
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("sex", sex);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("birthday", birthday);
    Pair<String, Integer> _mappedTo_3 = Pair.<String, Integer>of("class_id", Integer.valueOf(class_id));
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("tel", tel);
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("pid", pid);
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("school", school);
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("major", major);
    Pair<String, Integer> _mappedTo_8 = Pair.<String, Integer>of("year", Integer.valueOf(year));
    Pair<String, String> _mappedTo_9 = Pair.<String, String>of("state", state);
    Map<String, Object> map = Collections.<String, Object>unmodifiableMap(CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9));
    this.studentDao.insertStudent(map);
  }
  
  public boolean searchPidCount(final String pidInfo) {
    int count = this.studentDao.searchPidCount(pidInfo);
    if ((count > 0)) {
      return true;
    }
    return false;
  }
  
  public void updateStudentInfo(final int id, final String name, final String sex, final String birthday, final int class_id, final String tel, final String pid, final String school, final String major, final int year, final String state) {
    Pair<String, Integer> _mappedTo = Pair.<String, Integer>of("id", Integer.valueOf(id));
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("name", name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("sex", sex);
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("birthday", birthday);
    Pair<String, Integer> _mappedTo_4 = Pair.<String, Integer>of("class_id", Integer.valueOf(class_id));
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("tel", tel);
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("pid", pid);
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("school", school);
    Pair<String, String> _mappedTo_8 = Pair.<String, String>of("major", major);
    Pair<String, Integer> _mappedTo_9 = Pair.<String, Integer>of("year", Integer.valueOf(year));
    Pair<String, String> _mappedTo_10 = Pair.<String, String>of("state", state);
    Map<String, Object> map = Collections.<String, Object>unmodifiableMap(CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9, _mappedTo_10));
    this.studentDao.updateStudentInfo(map);
  }
}
