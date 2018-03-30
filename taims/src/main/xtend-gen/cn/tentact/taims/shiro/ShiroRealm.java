package cn.tentact.taims.shiro;

import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

@SuppressWarnings("all")
public class ShiroRealm extends AuthorizingRealm {
  /**
   * 授权方法
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(final PrincipalCollection arg0) {
    Subject subject = SecurityUtils.getSubject();
    Session session = subject.getSession();
    Object _attribute = session.getAttribute("privilege");
    List list = ((List) _attribute);
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    info.addStringPermissions(list);
    return info;
  }
  
  /**
   * 认证方法
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(final AuthenticationToken token) throws AuthenticationException {
    UsernamePasswordToken tk = ((UsernamePasswordToken) token);
    String username = tk.getUsername();
    char[] _password = tk.getPassword();
    String password = new String(_password);
    String _name = this.getName();
    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, _name);
    return info;
  }
}
