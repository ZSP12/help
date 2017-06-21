package test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by Administrator on 2017/6/5 0005.
 */
public class Shiro3 {
    public static void main(String[] args) {
        IniSecurityManagerFactory factory=new IniSecurityManagerFactory("classpath:shiro3.ini");
        SecurityManager manager=factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject user=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("aa","aa");
        try {
            user.login(token);
            System.out.println("登录："+user.isAuthenticated());
            boolean isAdmin=user.hasRole("admin");
            System.out.println("admin:"+isAdmin);
            boolean isCreate=user.isPermitted("user:create");
            System.out.println("权限"+isCreate);
        }catch (Exception e){
            System.out.println("登录失败");

        }
    }
}
