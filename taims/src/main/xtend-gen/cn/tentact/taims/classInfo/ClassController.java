package cn.tentact.taims.classInfo;

import cn.tentact.taims.classInfo.ClassService;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/class")
@SuppressWarnings("all")
public class ClassController {
  @Resource(name = "classService")
  private ClassService classService;
  
  @RequestMapping("/search/list")
  @ResponseBody
  public Map searchList() {
    List<Map> list = this.classService.searchList();
    Pair<String, List<Map>> _mappedTo = Pair.<String, List<Map>>of("result", list);
    return Collections.<String, List<Map>>unmodifiableMap(CollectionLiterals.<String, List<Map>>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/search/page")
  @ResponseBody
  public Map searchPage(final int start, final int length) {
    List<Map> list = this.classService.searchPage(start, length);
    Pair<String, List<Map>> _mappedTo = Pair.<String, List<Map>>of("result", list);
    return Collections.<String, List<Map>>unmodifiableMap(CollectionLiterals.<String, List<Map>>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/search/count")
  @ResponseBody
  public Map searchCount() {
    long count = this.classService.searchCount();
    Pair<String, Long> _mappedTo = Pair.<String, Long>of("count", Long.valueOf(count));
    return Collections.<String, Long>unmodifiableMap(CollectionLiterals.<String, Long>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/delete/id")
  @ResponseBody
  public Map deleteById(final int id) {
    this.classService.deleteById(id);
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("result", Boolean.valueOf(true));
    return Collections.<String, Boolean>unmodifiableMap(CollectionLiterals.<String, Boolean>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/delete/ids")
  @ResponseBody
  public Map deleteByIds(final int[] ids) {
    this.classService.deleteByIds(ids);
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("result", Boolean.valueOf(true));
    return Collections.<String, Boolean>unmodifiableMap(CollectionLiterals.<String, Boolean>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/insert/info")
  @ResponseBody
  public Map insertStudent(final String name, final String major, final String type, final String state, final int place_id) {
    this.classService.insertStudent(name, major, type, state, place_id);
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("result", Boolean.valueOf(true));
    return Collections.<String, Boolean>unmodifiableMap(CollectionLiterals.<String, Boolean>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/update/info")
  @ResponseBody
  public Map updateClassInfo(final int id, final String name, final String major, final String type, final String state, final int place_id) {
    InputOutput.<String>println((type + "sasas"));
    this.classService.updateClassInfo(id, name, major, type, state, place_id);
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("result", Boolean.valueOf(true));
    return Collections.<String, Boolean>unmodifiableMap(CollectionLiterals.<String, Boolean>newHashMap(_mappedTo));
  }
}
