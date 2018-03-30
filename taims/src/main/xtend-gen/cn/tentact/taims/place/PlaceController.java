package cn.tentact.taims.place;

import cn.tentact.taims.place.PlaceService;
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
@RequestMapping("/place")
@SuppressWarnings("all")
public class PlaceController {
  @Resource(name = "placeService")
  private PlaceService placeService;
  
  @RequestMapping("/search/list")
  @ResponseBody
  public Map searchList() {
    List<Map> list = this.placeService.searchList();
    Pair<String, List<Map>> _mappedTo = Pair.<String, List<Map>>of("result", list);
    return Collections.<String, List<Map>>unmodifiableMap(CollectionLiterals.<String, List<Map>>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/search/page")
  @ResponseBody
  public Map searchPage(final int start, final int length) {
    List<Map> list = this.placeService.searchPage(start, length);
    Pair<String, List<Map>> _mappedTo = Pair.<String, List<Map>>of("result", list);
    return Collections.<String, List<Map>>unmodifiableMap(CollectionLiterals.<String, List<Map>>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/search/count")
  @ResponseBody
  public Map searchCount() {
    long count = this.placeService.searchCount();
    Pair<String, Long> _mappedTo = Pair.<String, Long>of("count", Long.valueOf(count));
    return Collections.<String, Long>unmodifiableMap(CollectionLiterals.<String, Long>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/delete/id")
  @ResponseBody
  public Map deleteById(final int id) {
    this.placeService.deleteById(id);
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("result", Boolean.valueOf(true));
    return Collections.<String, Boolean>unmodifiableMap(CollectionLiterals.<String, Boolean>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/delete/ids")
  @ResponseBody
  public Map deleteByIds(final int[] ids) {
    this.placeService.deleteByIds(ids);
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("result", Boolean.valueOf(true));
    return Collections.<String, Boolean>unmodifiableMap(CollectionLiterals.<String, Boolean>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/insert/info")
  @ResponseBody
  public Map insertPlace(final String name) {
    this.placeService.insertPlace(name);
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("result", Boolean.valueOf(true));
    return Collections.<String, Boolean>unmodifiableMap(CollectionLiterals.<String, Boolean>newHashMap(_mappedTo));
  }
  
  @RequestMapping("/update/info")
  @ResponseBody
  public Map updatePlaceInfo(final int id, final String name) {
    this.placeService.updatePlaceInfo(id, name);
    Pair<String, Boolean> _mappedTo = Pair.<String, Boolean>of("result", Boolean.valueOf(true));
    return Collections.<String, Boolean>unmodifiableMap(CollectionLiterals.<String, Boolean>newHashMap(_mappedTo));
  }
}
