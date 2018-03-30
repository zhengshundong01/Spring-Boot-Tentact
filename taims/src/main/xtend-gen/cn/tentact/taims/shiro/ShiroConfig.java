package cn.tentact.taims.shiro;

import cn.tentact.taims.shiro.ShiroRealm;
import java.util.Collections;
import java.util.Map;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("all")
public class ShiroConfig {
  @Bean
  public ShiroFilterFactoryBean shirFilter(final org.apache.shiro.mgt.SecurityManager manager) {
    ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();
    factory.setSecurityManager(manager);
    factory.setLoginUrl("login.html");
    factory.setUnauthorizedUrl("/403.html");
    factory.setSuccessUrl("/index.html");
    Pair<String, String> _mappedTo = Pair.<String, String>of("/img/**", "anon");
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("/js/**", "anon");
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("/test/**", "anon");
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("/login.html", "anon");
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("/login.css", "anon");
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("/login.js", "anon");
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("/user/login", "anon");
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("/**", "authc");
    Map<String, String> map = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7));
    factory.setFilterChainDefinitionMap(map);
    return factory;
  }
  
  @Bean
  public DefaultWebSecurityManager securityManager() {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    ShiroRealm _shiroRealm = new ShiroRealm();
    securityManager.setRealm(_shiroRealm);
    return securityManager;
  }
}
