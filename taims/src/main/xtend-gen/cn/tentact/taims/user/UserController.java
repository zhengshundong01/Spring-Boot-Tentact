package cn.tentact.taims.user;

import cn.tentact.taims.privilege.PrivilegeService;
import cn.tentact.taims.user.UserService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@SuppressWarnings("all")
public class UserController {
  @Resource(name = "userService")
  private UserService userService;
  
  @Resource(name = "privilegeService")
  private PrivilegeService privilegeService;
  
  @RequestMapping("/login")
  public String login(final String username, final String password) {
    boolean bool = this.userService.login(username, password);
    if (bool) {
      List<Map> list = this.privilegeService.searchUserPrivilege(username);
      Subject subject = SecurityUtils.getSubject();
      Session session = subject.getSession();
      session.setAttribute("privilege", list);
      UsernamePasswordToken token = new UsernamePasswordToken(username, password);
      subject.login(token);
      return "redirect:/index.html";
    } else {
      return "redirect:/login.html";
    }
  }
}
