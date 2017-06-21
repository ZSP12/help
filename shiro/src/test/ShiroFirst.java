package test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by Administrator on 2017/6/5 0005.
 */
public class ShiroFirst {
    public static void main(String[] args) {
        try {
            IniSecurityManagerFactory path=new IniSecurityManagerFactory("classpath:shiro.ini");
            SecurityManager sm=path.getInstance();
            SecurityUtils.setSecurityManager(sm);
            Subject user=SecurityUtils.getSubject();
            UsernamePasswordToken token=new UsernamePasswordToken("bb","bb");

            user.login(token);
           boolean isAdmin= user.hasRole("admin");
            System.out.println("属于角色admin:"+isAdmin);
            boolean isCreate=user.isPermitted("user:create");
            System.out.println("持有权限create："+isCreate);
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }catch (UnknownAccountException e){
            System.out.println("账号不存在");
        }
    }
}
