package cn.tentact.taims.student;

import cn.tentact.taims.student.InfoService;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student/info")
@SuppressWarnings("all")
public class InfoController {
  @Resource(name = "infoService")
  private InfoService infoService;
  
  @RequestMapping("/search/Count")
  @ResponseBody
  public Map searchCount() {
    long count = this.infoService.searchCount();
    Pair<String, Long> _mappedTo = Pair.<String, Long>of("count", Long.valueOf(count));
    return Collections.<String, Long>unmodifiableMap(CollectionLiterals.<String, Long>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/search/Page")
  @ResponseBody
  public Map searchPage(final int start, final int length) {
    List<Map> list = this.infoService.searchPage(start, length);
    Pair<String, List<Map>> _mappedTo = Pair.<String, List<Map>>of("result", list);
    return Collections.<String, List<Map>>unmodifiableMap(CollectionLiterals.<String, List<Map>>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/delete/id")
  @ResponseBody
  public Map deleteById(final int id) {
    this.infoService.deleteById(id);
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("result", Boolean.valueOf(true));
    return Collections.<String, Boolean>unmodifiableMap(CollectionLiterals.<String, Boolean>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/delete/ids")
  @ResponseBody
  public Map deleteByIds(final int[] ids) {
    this.infoService.deleteByIds(ids);
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("result", Boolean.valueOf(true));
    return Collections.<String, Boolean>unmodifiableMap(CollectionLiterals.<String, Boolean>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/insert/info")
  @ResponseBody
  public Map insertStudent(final String name, final String sex, final String birthday, final int class_id, final String tel, final String pid, final String school, final String major, final int year, final String state) {
    this.infoService.insertStudent(name, sex, birthday, class_id, tel, pid, school, major, year, state);
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("result", Boolean.valueOf(true));
    return Collections.<String, Boolean>unmodifiableMap(CollectionLiterals.<String, Boolean>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/search/pidCount")
  @ResponseBody
  public Map searchPidCount(final String pid) {
    boolean bool = this.infoService.searchPidCount(pid);
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("result", Boolean.valueOf(bool));
    return Collections.<String, Boolean>unmodifiableMap(CollectionLiterals.<String, Boolean>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/update/info")
  @ResponseBody
  public Map updateStudentInfo(final int id, final String name, final String sex, final String birthday, final int class_id, final String tel, final String pid, final String school, final String major, final int year, final String state) {
    this.infoService.updateStudentInfo(id, name, sex, birthday, class_id, tel, pid, school, major, year, state);
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("result", Boolean.valueOf(true));
    return Collections.<String, Boolean>unmodifiableMap(CollectionLiterals.<String, Boolean>newHashMap(_mappedTo));
  }
}
