package com.resources;

import com.error.AppException;
import com.error.ExceptionType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


@Path("")
public class Login {
    @Path("login")
    @GET
    public String login(@QueryParam("username")String username,@QueryParam("password")String password){
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        Subject sub = SecurityUtils.getSubject();
        try {
            sub.login(token);
        } catch (UnknownAccountException uae) {
            System.out.println("用户名不存在:" + token.getPrincipal());
        } catch (IncorrectCredentialsException ice) {
            System.out.println("账户密码 " + token.getPrincipal() + " 不正确!");
        } catch (LockedAccountException lae) {
            System.out.println("用户名 " + token.getPrincipal() + " 被锁定 !");
        }
        // 认证成功后
        if (sub.isAuthenticated()) {
            System.out.println("用户 " + sub.getPrincipal() + " 登陆成功！");
        }else{
            throw new AppException(ExceptionType.NO_LOGIN);
        }
        return "success";
    }
    @Path("no_login")
    @GET
    public String index(){
        return "未登录";
    }
}
